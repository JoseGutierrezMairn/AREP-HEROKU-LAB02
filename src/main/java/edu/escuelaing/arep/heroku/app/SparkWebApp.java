package edu.escuelaing.arep.heroku.app;


import static spark.Spark.*;

import spark.Request;
import spark.Response;
import edu.escuelaing.arep.heroku.app.calculator.*;

public class SparkWebApp {
	private static Calculator c;
	private static Node n;
	private static JoseLinkedList jl;
	
	public static void main(String[] args) {
		c =  new Calculator();
		port(getPort());
		get("/calculadora", (req, res) -> calculadoraPage(req, res));
		get("/calcule", (req, res) -> calcule(req, res));
	}
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
	}
	
	private static String calculadoraPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                	+ "<title>Calculadora AREP - 2021-1</title>"
                + "<style>"
            	
                + "@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@600&display=swap');"
                + "h1,h2 {"
                +	"font-family: 'Orbitron', sans-serif"
                + "}"
    			
                + "input[type=text], select { "
                    + "width: 35%;"
                    + "padding: 12px 20px;"
                    + "margin: 8px 0;"
                    + "display: inline-block;"
                    + "border: 1px solid #ccc;"
                    + "border-radius: 4px;"
                    + "box-sizing: border-box;"
                + "}"
                
                + "input[type=submit] { "
                + "    width: 13%;"
                + "    background-color: #4CAF50;"
                + "    color: white; "
                + "    padding: 14px 20px;"
                + "    margin: 8px 0;"
                + "    border: none;"
                + "    border-radius: 4px;"
                + "    cursor: pointer;"
                + "}"

                + "input[type=submit]:hover {"
                + "background-color: #45a049;"
                + "}"
                
                +"</style>"
                +"</head>"
                + "<body bgcolor='black'>"
                + "<h1><FONT COLOR='red'>Calculadoras</FONT></h1>"
                + "<h2><FONT COLOR='white'>Digite los numeros en el siguiente cuadro:</FONT></h2>"
                + "<form action=\"/calcule\">"
                	+ "  <input type=\"text\" name='numeros'>"
                	+ "  <input type=\"submit\" value=\"Calcular\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
	
	
	private static String calcule(Request req, Response res) {
		String[] v = req.queryParams("numeros").split(",");
		String answ;
		jl = new JoseLinkedList();
		for(String s : v) {
			jl.addFirst(new Node(Double.parseDouble(s)));
		}
		double media = c.calculateMeanOf(jl);
		double derivacion = c.calculateStandardDerivationOf(jl, media);
        answ = "<!DOCTYPE html>"
        		+ "<html>"
        		+ "<head>"
            	+ "<title>Calculadora AREP - 2021-1</title>"
            	+ "<style>"
        	
            	+ "@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@600&display=swap');"
            	+ "h1{"
            	+	"font-family: 'Orbitron', sans-serif"
            	+ "}"
            	+ "</style>"
                + "<body bgcolor='black'>"
                	+ "<h1> <FONT COLOR='white'>" + "La Media de la lista de datos es: "+ media +"</FONT><h1>"
                	+ "<h1> <FONT COLOR='white'>" + "La Media de la lista de datos es: "+ derivacion +"</FONT><h1>"
                + "<form>"
                	+ "<input type=\"button\" value=\"Regresar\" onclick=\"history.back()\">"
                + "</form>"
                + "</body>"
                + "</html>";
        
        return answ;
    }

}