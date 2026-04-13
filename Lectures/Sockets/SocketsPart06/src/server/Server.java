package server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class Server {
	
	private ServerSocket server;
	private SSLSocket client;
	private int port;
	
	public Server(int port) {
		this.port = port;
	}
	
	public void run() {
		try {
			String passwd = "password";
			char[] password = passwd.toCharArray();
			// keystore - repository for storing security certificates and private keys
			
			// to generated a keystore:
			// 		keytool -genkeypair -keyalg ed25519 -validity 365 -alias mykey -keystore keystore.jks
			//	you may have to look up different key algorithms and key lengths, but ed25519 is popular and strong
			// 		keytool -genkeypair -keyalg RSA -keysize 2048 -validity 365 -alias mykey -keystore keystore.jks
			//	you can import your own keys into the keystore
			//	validity is 365 days in this example
			//	it can be JKS or PKCS12
			// note that the keystore must be on both client and server side
			
			KeyStore keyStore = KeyStore.getInstance("JKS"); 
			FileInputStream keystorefile = new FileInputStream("files/keystore.jks");
			keyStore.load(keystorefile, password);
			
			// key manager - creates key managers
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(keyStore, password);
            
			// SSL context - sets ups the security protocols
			// uses the keys and trust managers for authentication and communication 
			// TLSv1.3 is the latest as of 4/12/2026, some environments may require earlier versions
            SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
            sslContext.init(kmf.getKeyManagers(), null, null);
            
            // SSL Socket Factory - creates the server sockets
            SSLServerSocketFactory ssf = sslContext.getServerSocketFactory();
            
            // the server socket
            server = (SSLServerSocket) ssf.createServerSocket(port);
			
			System.out.println("Server started.");
			System.out.println("Server Info: " + server.getLocalSocketAddress());
			System.out.println("Waiting for client");
		
			while (true) {
				client = (SSLSocket) server.accept();
				Thread t = new Thread(new Handler(client));
				t.start();
			}
			
		} catch (IOException e) {
			System.err.println(e);
		} catch (KeyStoreException e) {
			System.err.println(e);
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		} catch (CertificateException e) {
			System.err.println(e);
		} catch (UnrecoverableKeyException e) {
			System.err.println(e);
		} catch (KeyManagementException e) {
			System.err.println(e);
		} 
	}
	
}
