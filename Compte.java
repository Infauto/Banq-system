import java.util.Scanner;
import java.time.LocalDateTime;


public class Compte extends Exception implements interface_compte
{
	Compte()
	{
		m_solde = 0;
		System.out.println(m_solde);
		m_nom_proprietaire = "Costumer" + String.valueOf(m_inconnus);
		m_inconnus++;
	}
	
	Compte(String nom)
	{
		m_nom_proprietaire=nom;
		m_solde = 0;
		Compte LIV_A=new Compte(nom,0);
	}
	
	
	Compte(String nom,int solde)
	{
		m_nom_proprietaire = nom;
		m_solde = solde;
		Compte LIV_A=new Compte(0);
	}
	
	Compte(int solde)
	{
		m_solde += solde;
		System.out.println(m_solde);
		m_nom_proprietaire = "Costumer" + String.valueOf(m_inconnus);
		m_inconnus++;
	}
	
	public Compte ajout_compte()
	{
		
	}
	
	public Compte retrait_compte()
	{
		
	}
	
	public Compte injection () 
	{
			Scanner sc = new Scanner(System.in);
			String str;
			char reponse;
			int injection;
			boolean boucle = false;
			int i = 0;
			DeclenchementException Objet= new DeclenchementException(); 
			
		do
		{
		
		
			System.out.println("Veuillez saisir la somme de votre injection.");
			injection = sc.nextInt(10);
			//Trouver une solution pour verifer l'integriter de la saisie clavier
			
			System.out.println("Veuillez entrer l'origine de ce depôt.");
			str = sc.nextLine();
			//Trouver une solution pour verifer l'integriter de la saisie clavier
					
			System.out.println("Voulez-vous effectuer un autre depôt ? O/n");
			
			reponse = sc.next().charAt(0);
			
			if(reponse == 'O' || reponse == 'o' || reponse == 0x00)
				boucle = true;
				
			else
				boucle = false;
				
			
		}
		while(boucle == true);
		
		System.out.println("Votre solte est desormais de " + m_solde + "€");
			
		return this;
	}
	
	public Compte retrait(int somme, String source)
	{
		boolean boucle = false;
		Scanner sc = new Scanner(System.in);
		char reponse;
		String str;
		String provisoir;
		LocalDateTime Time = LocalDateTime.now();
		
		System.out.println("Veuillez preciser la raison de ce retrait");
		m_raison_retrait = sc.nextLine();
		
		System.out.println("Veuillez saisir la somme de votre retrait.");
		m_somme_retrait = sc.nextInt();
		
		liaison_tab_cellule(m_raison_retrait, m_somme_retrait);
			
			if(m_solde - somme >= 0)
				m_solde = m_solde - m_somme_retrait;
			do
		{
		
		
			/*
			*
			*
			* Programmer la limitation de retrait
			*
			*
			*
			*/
			
			//System.out.println("Facultatif: Veuillez entrer l'origine de ce depôt.");
			str = source;
			
			System.out.println("Voulez-vous effectuer un autre retrait ? O/n");
			
			reponse = sc.next().charAt(0);
			
			if(reponse == 'O' || reponse == 'o')
				boucle = true;
				
			else
				boucle = false;
				
			
		}
		while(boucle == true);
		
		System.out.println("Votre solte est desormais de " + m_solde + "€");
		
		return this;
		
	}
	
	public Compte transaction(int montant, String destinataire)
	{
		if(m_solde - montant >= 0)
			m_solde -= montant;
			
		System.out.println("transaction effectuer à destination de :" + destinataire + "d'un montant de : " + m_solde + "€.");
			
		return this;
	}
	
	public Compte liaison_tab_cellule(String raison_retrait, int somme_retrait)
	{
		verification_tab_raison_retrait();
		verification_tab_somme_retrait();
		
		int i = 0;
		
		if(m_tab_raison_retrait == null)
		{
			m_tab_raison_retrait[0] = raison_retrait;
			m_tab_somme_retrait[0] = somme_retrait;
			
		}
		
		do
			i++;
		while(m_tab_raison_retrait[i] != null);
		
			verification_tab_raison_retrait();
			m_tab_raison_retrait[i] = raison_retrait;
			
			verification_tab_somme_retrait();
			m_tab_somme_retrait[i] = somme_retrait;
		
		return this;
	}
	
	public Compte verification_tab_raison_retrait()
	{
		
		String verification_tab_raison_retrait[] = new String[m_taille_tab];
		
		verification_tab_raison_retrait = m_tab_raison_retrait;
		
		//if(verification_tab_raison_retrait[0] == null)
			//verification_tab_raison_retrait[0] = m_tab_raison_retrait[0];
			
		for(int i = 0; i<m_taille_tab;i++)
		{
			for(int ii = 0; ii< m_taille_tab; ii++)
			{
				if(verification_tab_raison_retrait[ii] == m_tab_raison_retrait[i] && i == ii)
					continue;
				else if(verification_tab_raison_retrait[ii] == m_tab_raison_retrait[i] && i != ii)
				{
					verification_tab_raison_retrait[i] = m_tab_raison_retrait[i];
					verification_tab_raison_retrait[ii] = null;
					//Algorythme de concaténation des somme par raison de retrait
				}
					
				if (verification_tab_raison_retrait[ii+1] != null && ii <= m_taille_tab)
					deplacement_indices_tab(verification_tab_raison_retrait);	
			}		
						
		
		}
		return this;
	}
	
	public Compte verification_tab_somme_retrait()
	{
		int verification_tab_somme_retrait[] = new int[m_taille_tab];
		
		return this;
	}
	
	
	public String [] deplacement_indices_tab(String [] tab_membre)
	{
		String verification_tab_membre[] = new String[m_taille_tab];
		verification_tab_membre = tab_membre;
		
		for(int i = 0; verification_tab_membre[i] != null; i++)
			for(int ii = i; verification_tab_membre[ii] == null; i++ )
			{
				verification_tab_membre[i] = verification_tab_membre[ii];
				verification_tab_membre[ii] = null;
			}
		return verification_tab_membre;
	}
	
	
	public int [] deplacement_indices_tab(int tab_membre)
	{
		int tab[] = new int[10];
		return tab;
	}
	
	
	public boolean parcourt_tab (String [] tab, int courant, int max)
	{
		for(int i = courant; courant < max; i++)
		{
			//if(tab[i] == null)
				//continue;
			if(courant == max && tab[i] == null)
				return true;
			else
				return false;
		}
		return false;
	}
	
	public boolean parcourt_tab(int [] tab, int courant, int max)
	{
		return true;
	}
	
	
	private String 	m_nom_proprietaire;
	private int 		m_solde;
	private Compte	m_comptes[m_nb_comptes];
	private int 		m_nb_comptes = 10; //faire une gestion du nombre de compte
	
	private int			m_inconnus = 0;
	private int 		m_taille_tab = 10;
	
	private String 	m_tab_raison_retrait[] = new String[m_taille_tab];
	private int 		m_tab_somme_retrait[] = new int[m_taille_tab];
	
	private String 	m_raison_retrait;
	private int 		m_somme_retrait;
	
	
}
