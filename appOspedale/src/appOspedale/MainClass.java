package appOspedale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainClass {
	
	/**
	 * Applicazione che permette di eseguire le operazioni descritte nella relazione del progetto.
	 *  
	 * 
	 */
	public static void main(String[] args){
		
		String menu =   "0)Stampa questo menu'\r\n" +
						"1)Tutti i codici dei pazienti ricoverati gestiti dal medico con matricola MATRICOLA_M\r\n" + 
						"2)Tutte le medicine(con relativo dosaggio) prese dal paziente con codice paziente COD_PAZ\r\n" + 
						"3)Tutti i dispositivi medici impiantabili del paziente con codice COD_PAZ\r\n" + 
						"4)Tutte le terapie relative al paziente con codice COD_PAZ\r\n" + 	
						"5)Visualizzare per la lista d'attesa COD_LISTA i relativi pazienti(codici) ordinati per data di inserimento crescente\r\n" + 
						"6)Tutte le sale operatorie che hanno almeno la stessa strumentazione della sala operatoria con codice CODICE_SALA_E\r\n"+
						"7)Inserimento di un intervento\r\n" + 
						"8)Inserimento di una terapia\r\n"+
						"9)Inserimento di una visita\r\n"+
						"10)Inserimento di un referto\r\n"+
						"11)Malattia/e più diffusa/e tra i pazienti ricoverati\r\n"+
						"12)Quantità di letti liberi per reparto\r\n" + 
						"13)Visite effettuate da un medico di matricola MATRICOLA_M a partire da DATA_ORA_MIN\r\n"+
						"-1)Esci\r\n";
		
		
		String op1 = "SELECT lista_pazienti_medico('";	
		String op2 = "SELECT lista_medicine_paziente('";	
		String op3 = "SELECT lista_impiantabili_paziente('";	
		String op4 = "SELECT lista_terapie_paziente('";	
		String op5 = "SELECT lista_dattesa('";	
		String op6 = "SELECT sale_op_equivalenti('";
		String op7 = "SELECT inserimento_intervento('";
		String op8 = "SELECT inserimento_terapia('";
		String op9 = "SELECT inserimento_visita('";
		String op10 = "SELECT inserimento_referto('";
		String op11 = "SELECT malattia_piu_diffusa();";
		String op12 = "SELECT letti_liberi_per_reparto();";
		String op13 = "SELECT visite_medico_periodo('";
				
		
		try{
			Class.forName ("org.postgresql.Driver");  // Load the Driver
			Scanner in = new Scanner(System.in);
			
			Connection conn = DriverManager.getConnection( "jdbc:postgresql://dumbo.db.elephantsql.com:5432/hxqdmbaa", "hxqdmbaa", "dP7QmzKWABOEPhSTd5caqNkfunh_97A9" );
			System.out.println("Connessione riuscita.\r\n\r\n");
			System.out.println(menu);
			
			int scelta = 0;
			do {
				System.out.println("\r\nImmetti numero operazione: ");
				
				scelta = Integer.parseInt(in.nextLine());
				
				
				switch(scelta)
				{
					case 0:
					{
						System.out.println(menu);
						break;
					}
					case 1:
					{
						Statement stmt = conn.createStatement();
						
						System.out.println("Inserisci MATRICOLA_M(prova: 232323): ");
						String inputDato = in.nextLine();
						ResultSet rs = stmt.executeQuery(op1 + inputDato + "');");
						System.out.println("COD_PAZ");
						while (rs.next()) 
						{
							String paziente = rs.getString("lista_pazienti_medico");
							System.out.println(paziente);
						}
						rs.close();
						stmt.close();
						break;
					}
					case 2:
					{
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci COD_PAZ(prova: 122232): ");
						String inputDato = in.nextLine();
						ResultSet rs = stmt.executeQuery(op2 + inputDato + "');");
						System.out.println("COD_AIC, COD_ATC, NOME, DOSAGGIO");
						while (rs.next()) 
						{
							String medicina = rs.getString("lista_medicine_paziente");
							System.out.println(medicina);
						}
						rs.close();
						stmt.close();
						break;
					}
					case 3:
					{
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci COD_PAZ(prova: 122232): ");
						String inputDato = in.nextLine();
						ResultSet rs = stmt.executeQuery(op3 + inputDato + "');");
						System.out.println("CODICE_CND, CODICE_SERIALE");
						while (rs.next()) 
						{
							String impiantabile = rs.getString("lista_impiantabili_paziente");
							System.out.println(impiantabile);
						}
						rs.close();
						stmt.close();
						break;
					}
					case 4:
					{
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci COD_PAZ(prova: 122232): ");
						String inputDato = in.nextLine();
						ResultSet rs = stmt.executeQuery(op4 + inputDato + "');");
						System.out.println("NOME_TER");
						while (rs.next()) 
						{
							String terapia = rs.getString("lista_terapie_paziente");
							System.out.println(terapia);
						}
						rs.close();
						stmt.close();
						break;
					}
					case 5:
					{
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci COD_LISTA(prova: 111111): ");
						String inputDato = in.nextLine();
						ResultSet rs = stmt.executeQuery(op5 + inputDato + "');");
						System.out.println("COD_PAZIENTE, DATA_INS");
						while (rs.next()) 
						{
							String elementoListaDattesa = rs.getString("lista_dattesa");
							System.out.println(elementoListaDattesa);
						}
						rs.close();
						stmt.close();
						break;
					}
					case 6:
					{
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci CODICE_SALA(prova: 123): ");
						String inputDato = in.nextLine();
						ResultSet rs = stmt.executeQuery(op6 + inputDato + "');");
						System.out.println("COD_SALA");
						while (rs.next()) 
						{
							String sala_op = rs.getString("sale_op_equivalenti");
							System.out.println(sala_op);
						}
						rs.close();
						stmt.close();
						break;
					}
					
					case 7:
					{
						//inserimento_intervento(DATA DATE, CODICE_EQUIPE CHAR(6), COD_PAZIENTE CHAR(6), 
						//CODICE_SALA CHAR(3), FASCIA_ORARIA INT, COD_INTERVENTO CHAR(6), DESCRIZIONE TEXT, DENOM_TIPO CHAR(25)) 
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci data(aaaa-mm-gg): ");
						String inputDato1 = in.nextLine();
						System.out.println("Inserisci codice equipe: ");
						String inputDato2 = in.nextLine();
						System.out.println("Inserisci codice paziente: ");
						String inputDato3 = in.nextLine();
						System.out.println("Inserisci codice sala: ");
						String inputDato4 = in.nextLine();
						System.out.println("Inserisci fascia oraria(scegli tra il valore 1 o il valore 2): ");
						String inputDato5 = in.nextLine();
						System.out.println("Inserisci codice intervento: ");
						String inputDato6 = in.nextLine();
						System.out.println("Inserisci descrizione: ");
						String inputDato7 = in.nextLine();
						System.out.println("Inserisci denominazione tipo di intervento: ");
						String inputDato8 = in.nextLine();
						ResultSet rs = stmt.executeQuery(op7 + inputDato1 + "','" + inputDato2 + "','" + inputDato3 + "','" + inputDato4
								 + "'," + inputDato5 + ",'" + inputDato6 + "','" + inputDato7 + "','" + inputDato8 + "');");
						
						System.out.println("Intervento inserito");
						
						rs.close();
						stmt.close();
						break;
					}
					case 8:
					{
						
						//inserimento_terapia(COD_PAZIENTE CHAR(6), NOME_TERAPIA VARCHAR(100), 
						//GIORNO_SETT INT, ORA TIME, CODICE_SALA CHAR(3)) 
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci codice paziente: ");
						String inputDato1 = in.nextLine();
						System.out.println("Inserisci nome terapia: ");
						String inputDato2 = in.nextLine();
						System.out.println("Inserisci giorno della settimana(1,2,3,4,5,6,7): ");
						String inputDato3 = in.nextLine();
						System.out.println("Inserisci ora(es. hh:mm): ");
						String inputDato4 = in.nextLine();
						System.out.println("Inserisci codice sala: ");
						String inputDato5 = in.nextLine();
						
						ResultSet rs = stmt.executeQuery(op8 + inputDato1 + "','" + inputDato2 + "'," + inputDato3 + ",'" + inputDato4
								 + "','" + inputDato5 + "');");
						
						System.out.println("Terapia inserita");
						
						rs.close();
						stmt.close();
						break;
					}
					case 9:
					{
						//inserimento_visita(CODICE_VISITA CHAR(6), DATA_ORA TIMESTAMP, COD_AMB CHAR(6),
						//COD_PAZIENTE CHAR(6), DESCRIZIONE VARCHAR)
						
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci codice visita: ");
						String inputDato1 = in.nextLine();
						System.out.println("Inserisci data_ora(aaaa-mm-gg hh:mm): ");
						String inputDato2 = in.nextLine();
						System.out.println("Inserisci codice ambulatorio: ");
						String inputDato3 = in.nextLine();
						System.out.println("Inserisci codice paziente: ");
						String inputDato4 = in.nextLine();
						System.out.println("Inserisci descrizione: ");
						String inputDato5 = in.nextLine();
						
						ResultSet rs = stmt.executeQuery(op9 + inputDato1 + "','" + inputDato2 + "','" + inputDato3 + "','" + inputDato4
								 + "','" + inputDato5 + "');");
						
						System.out.println("Visita inserita");
						
						rs.close();
						stmt.close();
						break;
					}
					case 10:
					{
						//inserimento_referto(CODICE_VISITA CHAR(6), TIPO_ESAME VARCHAR(150), DESCRIZIONE VARCHAR, COD_LAB CHAR(4)) 
						Statement stmt = conn.createStatement();
						System.out.println("Inserisci codice visita: ");
						String inputDato1 = in.nextLine();
						System.out.println("Inserisci tipo esame: ");
						String inputDato2 = in.nextLine();
						System.out.println("Inserisci descrizione: ");
						String inputDato3 = in.nextLine();
						System.out.println("Inserisci codice laboratorio: ");
						String inputDato4 = in.nextLine();
						
						
						ResultSet rs = stmt.executeQuery(op10 + inputDato1 + "','" + inputDato2 + "','" + inputDato3 + "','" + inputDato4 + "');");
						
						System.out.println("Referto inserito");
						
						rs.close();
						stmt.close();
						break;
					}
					case 11:
					{
						Statement stmt = conn.createStatement();
	
						ResultSet rs = stmt.executeQuery(op11);
						System.out.println("COD_ICD10, numero_malati");
						while (rs.next()) 
						{
							String malattia = rs.getString("malattia_piu_diffusa");
							System.out.println(malattia);
						}
						rs.close();
						stmt.close();
						
						break;
					}
					case 12:
					{
						Statement stmt = conn.createStatement();
	
						ResultSet rs = stmt.executeQuery(op12);
						System.out.println("COD_REP, LETTI_LIBERI");
						while (rs.next()) 
						{
							String letto = rs.getString("letti_liberi_per_reparto");
							System.out.println(letto);
						}
						rs.close();
						stmt.close();
						
						break;
					}
					case 13:
					{
						//visite_medico_periodo(MATR_M CHAR(6), DATA_ORA_MIN TIMESTAMP)

						Statement stmt = conn.createStatement();
						System.out.println("Inserisci MATRICOLA_M: ");
						String inputDato1 = in.nextLine();
						System.out.println("Inserisci DATA_ORA_MIN(aaaa-mm-gg hh:mm): ");
						String inputDato2 = in.nextLine();
						
						
						ResultSet rs = stmt.executeQuery(op13 + inputDato1 + "','" + inputDato2 + "');");
						System.out.println("CODICE_VISITA, DATA_ORA, COD_AMB, COD_PAZIENTE, DESCRIZIONE");
						while (rs.next()) 
						{
							String visita = rs.getString("visite_medico_periodo");
							System.out.println(visita);
						}
				
						rs.close();
						stmt.close();
						break;
					}
					case -1:
						break;
				}
				
			}while(scelta != -1);
			
			in.close();
			conn.close();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
