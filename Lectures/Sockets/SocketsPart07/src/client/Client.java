package client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class Client {
	
	private SSLSocket conn;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private int ID;
	private String addr;
	private int port;

	public Client(int ID, String addr, int port) {
		this.ID = ID;
		this.addr = addr;
		this.port = port;
	}
	
	public void run() {
		try {
			String passwd = "password";
			char[] password = passwd.toCharArray();
			
			KeyStore keyStore = KeyStore.getInstance("JKS");
			FileInputStream keystorefile = new FileInputStream("files/keystore.jks");
			keyStore.load(keystorefile, password);
			
			// trust managers - manage specific types of trust
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			tmf.init(keyStore);
			
			SSLContext sslContext = SSLContext.getInstance("TLSv1.3");
			sslContext.init(null, tmf.getTrustManagers(), null);
			
			SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			SSLSocket conn = (SSLSocket) sslSocketFactory.createSocket(addr, port);

			conn.startHandshake();
			
			//	ois/oos on both sides - blocks
			//  oos/oos on both sides - works
			//  ois/oos on server, oos/ois on client - works
			// 	oos/ois on server, ois/oos on client - works
			ois = new ObjectInputStream(conn.getInputStream());			
			oos = new ObjectOutputStream(conn.getOutputStream());

			while (true) {
				oos.writeObject(ID);
				
				String message = (String) ois.readObject();
				System.out.println("From server: " + message);
				Thread.sleep(1000);
			}
						
			//ois.close();
			//oos.close();
			//conn.close();
			
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} catch (InterruptedException e) {
			System.err.println(e);
		} catch (KeyStoreException e) {
			System.err.println(e);
		} catch (NoSuchAlgorithmException e) {
			System.err.println(e);
		} catch (CertificateException e) {
			System.err.println(e);
		} catch (KeyManagementException e) {
			System.err.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
	}
	
	
	
}
