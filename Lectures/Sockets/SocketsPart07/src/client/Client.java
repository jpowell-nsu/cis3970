package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Random;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

public class Client {
	
	private SSLSocket conn;
	private DataOutputStream dos;
	private DataInputStream dis;
	private int ID;
	private String addr;
	private int port;
	private int values[];

	public Client(int ID, String addr, int port) {
		this.ID = ID;
		this.addr = addr;
		this.port = port;
		this.values = new int[100];
		
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
			conn = (SSLSocket) sslSocketFactory.createSocket(addr, port);
			System.out.println(conn);

			conn.startHandshake();

			dis = new DataInputStream(this.conn.getInputStream());
			dos = new DataOutputStream(this.conn.getOutputStream());

			dos.writeInt(ID);
			String message = dis.readUTF();
			System.out.println("From server: " + message);
		
			dis.close();
			dos.close();
			conn.close();
			
		} catch (IOException e) {
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
