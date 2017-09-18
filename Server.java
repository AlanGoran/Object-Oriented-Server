import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class Servant extends Thread{
	Server server;
	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	
	public Servant(Server server, Socket socket){
		this.server=server;
		this.socket=socket;
		try{
			input=new ObjectInputStream(socket.getInputStream());
		    output=new ObjectOutputStream(socket.getOutputStream());
		}catch (IOException ioe){
		    System.out.println("IOFEL!!!1");}
	}
	
	public void closeConnection(){
		try{
			input.close();
			output.close();
			socket.close();
			server.remove(this);
		}catch (Exception e){
			e.printStackTrace();}
	}
	
	public void run(){
		Object p=null;
		do{
			try{
				p= input.readObject();
				server.send(this,p);
			}catch (IOException ioe){
				System.out.println("IOFEL!!!2");
				closeConnection();
				break;
		    }catch (ClassNotFoundException cnfe){
				System.out.println("IOFEL!!!3");
				System.exit(0);
			    }
		}while(p!=null);
	}
	
	public void send(Object p){
		try{
		    output.writeObject(p);
		    output.flush();
		}catch (IOException ioe){System.out.println("IOFEL!!!4");}
	}
}

class Server extends ServerSocket{
	
	ArrayList<Servant> servants;
	public Server(int port) throws IOException {
		super(port);
		servants = new ArrayList<Servant>();
	}
	
	public void send(Servant servant, Object p){
		for(Servant s:servants){
			if(s!=servant)
				s.send(p);
		}
	}
	
	public void remove(Servant s){
		servants.remove(s);
	}
	
	public void starta(){
		while(true){
			try{
				Socket socket=accept();
				Servant servant = new Servant(this, socket);
				servants.add(servant);
				servant.start();
			}catch(IOException ioe){
				System.out.println("xIOFEL!5");}
		}
	}
	
	public static void main(String[] args)throws IOException{
		Server server = new Server(1048);
		server.starta();
	}
	
}