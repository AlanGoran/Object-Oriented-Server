import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

class InputHelper extends Thread{
	ObjectInputStream input;
    Model model;
    Mus view;
    
    public InputHelper(ObjectInputStream input, Model m, Mus v){
    	this.input= input;
    	view= v;
    	model= m;
    }
    
    public void run(){
    	//Figure p = null;
    	Object p = null;
    	do{
    		try{
    			p= input.readObject();
    			model.addFigure(p);
    			view.drawAllFigures();
    		}catch (IOException ioe){
    			System.out.println("IOFEL-qwe!!!");
    			closeConnection();
    			//System.exit(0);
    		}catch (ClassNotFoundException cnfe){
    			System.out.println("IOFEL!!!");
    			//System.exit(0);
    		}catch (NullPointerException cnfe){
    			System.out.println("IOFELNULL!!!");
    		}
    	}while(p!=null);
    }
    
    public void closeConnection(){
    	try{
    	    input.close();
    	}catch (Exception e){
    	    e.printStackTrace();
    	    }
    }
}

public class Client {
	Socket socket;
    ObjectInputStream input;
    ObjectOutputStream output;
    InputHelper inputHelper;
    Model model;
    Mus view;
    
    public Client(InetAddress address, int port)throws IOException{
    	socket = new Socket(address, port);
    	model = new Model();
    	view = new Mus(model,this);
    	try{
    		output= new ObjectOutputStream(socket.getOutputStream());
		    input= new ObjectInputStream(socket.getInputStream());
		    inputHelper= new InputHelper(input,model, view);
		    inputHelper.start();
    	}catch (IOException ioe){
		    System.out.println("IOFEL!!!");
		    System.exit(0);
		}
    }
    
    public void sendObject(Object o){
    	try{
    		output.writeObject(o);
    	}catch (IOException ioe){
    	    System.out.println("IOFEL-asd!!!");
    	   // System.exit(0);
    	}
    }
    
    public static void main(String[] args)throws IOException{
    	Client client= new Client(InetAddress.getByName("127.0.0.1"), 1048);
    }
}
