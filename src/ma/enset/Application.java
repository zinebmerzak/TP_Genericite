package ma.enset;

public class Application {
	
	public static void main(String args[]) {
		
		MetierProduitImpl list = new MetierProduitImpl("items.txt");
		Produit p1 = new Produit(1, "PC Laptop", "HP", 12000, "HP Pavillon", 25);
		Produit p2 = new Produit(2, "IPhone", "Apple", 15000, "iPhone 13 Pro Max", 10);
		Produit p3 = new Produit(3, "Macbook", "Apple", 20000, "Macbook Pro", 5);
		Produit p4 = new Produit(4, "Smartphone S3", "Samsung", 8000, "Samsung Galaxy S3", 100);
		
		//add products to the list
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		//save function;
		
		System.out.println("Get All Items : ");
		
		MetierProduitImpl listProduit = new MetierProduitImpl("items.txt");
		
		for (Produit produit : listProduit.getAll()) {
			System.out.println(produit.toString());
		}
		
		System.out.println("Find All Items : ");
		Produit p = listProduit.findById(1);
		System.out.println(p.toString());
		
		System.out.println("Delete All Items");
		listProduit.delete(2);
		for (Produit produit : listProduit.getAll()) {
			System.out.println(produit.toString());
		}
	}
}
