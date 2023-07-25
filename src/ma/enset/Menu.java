package ma.enset;

import java.util.Scanner;

public class Menu {
	private static Produit p1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean b = true; 
		MetierProduitImpl listProduit = new MetierProduitImpl("items.txt");
		listProduit.getAll();
		
		System.out.println("Welcome to the Menu");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1 - Display Item List");
		System.out.println("2 - Find item by Id");
		System.out.println("3 - Add item");
		System.out.println("4 - Delete item by Id");
		System.out.println("5 - Save all");
		System.out.println("6 - Quit");
		
		while(b) {
			
			System.out.println("----------------------------------------------------------------- ");
			System.out.println("Select an operation :");
			
			int str = sc.nextInt();
			
			switch (str) {
			case 1:
				
				System.out.println("Item List");
				for (Produit produit : listProduit.getListProduit()) {
					System.out.println(produit.toString());
				}
				break;
			case 2:
				System.out.println("2 - Find item by Id");
				System.out.println("Enter an id : ");
				p1 = listProduit.findById(sc.nextLong());
				if(p1 == null) {
					System.out.println("Item does not exist!");
				}else {
					System.out.println(p1.toString());
				}
				break;
			case 3:
				
				System.out.println("3 - Add item");
				Produit p = new Produit();
				b = true;
				while(b) {
					System.out.println("Enter an id : ");
					Long id = sc.nextLong();
					if(listProduit.findById(id) == null) {
						p.setId(id);
						System.out.println("Enter a name : ");
						p.setNom(sc.next());
						sc.nextLine();
						System.out.println("Enter a brand : ");
						p.setMarque(sc.next());
						System.out.println("Enter a price : ");
						p.setPrix(sc.nextFloat());
						System.out.println("Enter a description : ");
						p.setDescription(sc.next());
						System.out.println("Enter an amount in stock : ");
						p.setNombreStock(sc.nextLong());
						listProduit.add(p);
						b = false;
					}else {
						System.out.println("This item exists already!");
					}
				}
				
				break;
			case 4:
				System.out.println("4 - Delete item by Id");
				System.out.println("Enter an id : ");
				Long id = sc.nextLong();
				p1 = listProduit.findById(id);
				if(p1 == null) {
					System.out.println("Item does not exist!");
				}else {
					listProduit.delete(id);
				}
				break;
			case 5:
				System.out.println("5 - Save all");
				listProduit.saveAll();
				break;
			case 6:
				b = false;
				System.out.println("See you later!");
				break;

			default:
				System.out.println("-");
				break;
			}
		}
		

	}
}
