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
	
	int clientcnt;	// count of connecting clients
	int total;		// total of all their values
	
	private ServerSocket server;
	private SSLSocket client;
	private int port;
	
	public Server(int port) {
		this.port = port;
		this.clientcnt = 0;
		this.total = 0;
	}
	
	public void run() {
		try {
			String passwd = "password";
			char[] password = passwd.toCharArray();

			KeyStore keyStore = KeyStore.getInstance("JKS"); 
			FileInputStream keystorefile = new FileInputStream("files/keystore.jks");
			keyStore.load(keystorefile, password);

			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			kmf.init(keyStore, password);

            SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
            sslContext.init(kmf.getKeyManagers(), null, null);

            SSLServerSocketFactory ssf = sslContext.getServerSocketFactory();

            server = (SSLServerSocket) ssf.createServerSocket(port);
			
			System.out.println("Server started.");
			System.out.println("Server Info: " + server.getLocalSocketAddress());
			System.out.println("Waiting for client");
			
			Thread t = new Thread(
					);
		
			while (true) {
				client = (SSLSocket) server.accept();
				new Thread(new Handler(client, clientcnt, total)).start();
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
