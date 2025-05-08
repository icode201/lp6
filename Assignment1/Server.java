import java.net.*;
import java.io.*;
public class Server
{
//initialize socket and input stream
private Socket
socket = null;
private ServerSocket server = null;
private DataInputStream in
= null;
// constructor with port
public Server(int port)
{
// starts server and waits for a connection
try
{
server = new ServerSocket(port);
System.out.println("Server started");
System.out.println("Waiting for a client ...");
socket = server.accept();
System.out.println("Client accepted");
// takes input from the client socket
in = new DataInputStream(
new BufferedInputStream(socket.getInputStream()));
String line = "";
// reads message from client until "Over" is sent
while (!line.equals("Over"))
{
try
{
line = in.readUTF();
System.out.println(line);
}
catch(IOException i)
{
System.out.println(i);
}
}
System.out.println("Closing connection");
// close connection
socket.close();
in.close();
}
catch(IOException i)
{
System.out.println(i);
}
}
public static void main(String args[])
{
Server server = new Server(5000);
}
}
/*
3.2.3.jar: command not found 
(base) tt-Vostro-3738-/Ashita Gore/Ast 25 javac Search.java 
(base) Itott-Vostro-3718-/Ahktta Gore/Axxignment 15 javac SearchQuery.java 
(base) itgit-Vostro-3738-/anksta Gore/Assignment 15 rnic SearchQue Warning: generation and use of skeletons and static stubs for 30AP 
Ls deprecated. Skeletons are unnecessary, and static stubs have been superseded by dynamically generated stubs. Users are encouraged to stgrate away from usting rate to generate skeletons and static stubs. See the documentation for java.iml.server.UnicastRemoteObject. 
(base) ttatt-Vostro-3718:-/Ankita Gore/Asalgnment 1$ rniregistry & 11 5384 
(base) itgit-Vostro-3738-/Ankita Gore/Assignment 15 javac Server.java (hase) ttatt-Vostro-3718-/Ankita Care/Asatgnment 15 java Server 
Server started 
Walting for a client Lent 
Citent accepted 
*/