package ma.enset;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
	
	List<Produit> listProduit;
	public String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public List<Produit> getListProduit() {
		return listProduit;
	}

	public void setListProduit(List<Produit> listProduit) {
		this.listProduit = listProduit;
	}
	
	public MetierProduitImpl(String fileName) {
		this.fileName = fileName;
		this.listProduit = new ArrayList<>();
	}

	@Override
	public void add(Produit o) {
		this.listProduit.add(o);
	}

	/*@Override
	public List<Produit> getAll() {
		return listProduit;
	}*/

	@Override
	public Produit findById(long id) {
		for(Produit p : this.listProduit) {
			if(id == p.getId())
				return p;
		}
		return null;
	}

	@Override
	public void delete(long id) {
		for(Produit p : this.listProduit) {
			if(id == p.getId())
				this.listProduit.remove(p);
		}
		
	}
	
	@Override
	public List<Produit> getAll() {
		
		try {
			File file = new File(this.fileName);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Produit> readObject = (List<Produit>) ois.readObject();
			this.listProduit = readObject;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.listProduit;
	}
	
	@Override
	public void saveAll() {
		try {
			File file = new File(this.fileName);
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			oos.writeObject(this.listProduit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
