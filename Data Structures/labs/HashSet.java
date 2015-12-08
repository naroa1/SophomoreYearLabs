package labs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HashSet<T> implements Set<T> {
	private ArrayList<LinkedList<T>> structure;
	private int size;
	public HashSet() {
		clear();
	}
	@Override
	public void clear() {
		// Let the garbage collector to the actual work for us :-)
		structure = new ArrayList<LinkedList<T>>();
		for (int i = 0; i < 13; i++) {
			structure.add(new LinkedList<T>());
		}
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public boolean add(T arg0) {
//      Hint: use arg0.hashCode();
//      Hint: do proper bookkeeping on the size
		
		int hashcode=arg0.hashCode()%12; //hashes and stores the value of the hash of the value to be added to the set
		
		if(structure.get(hashcode).size()!=0){
			if(structure.get(hashcode).contains(arg0)==false) //checking to make sure it isn't already in there!
				structure.get(hashcode).add(arg0); //grabs the existing linked list and throws the new value into it
		}
		else
		{
			LinkedList<T> node=new LinkedList<T>(); //will be used to store the list of values in the hash set
			node.add(arg0); //adds the value to the linked list
			structure.set(hashcode,node); //puts the linked list in the space assigned for it in hashing
			size++;
		}
			
		
		if(contains(arg0)==true)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean contains(Object o) {
		int hashcode=o.hashCode()%12; //determines the hash for the value we're checking for
		
		if(structure.get(hashcode)==null) //checks to see if there even is a linked list at the hash value
			return false;
		else //if there is, it continues on!
		{
			if(structure.get(hashcode).contains(o)==true) //checks to see if the linked list at the hash value contains the value
				return true;
			else
				return false;
		}
	}
	@Override
	public boolean remove(Object o) {
		if(contains(o)==false) //checks to make sure that the value is in fact in the set in the first place
			return false;
		else{
			int hashcode=o.hashCode()%12; //determines the hash code to make sure we get can delete the value
			if(structure.get(hashcode).remove(o)==true) //this removes the value and will check to make sure it was successful
				return true;
			else
				return false;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			Iterator<T> iterator = structure.get(0).iterator();
			{
				update();
			}
			private void update() {
				if (i > 12) return;
				while(iterator.hasNext()) {
					i++;
					iterator = structure.get(i).iterator();
				}
			}
			@Override
			public boolean hasNext() {
				update();
				return iterator.hasNext();
			}
			@Override
			public T next() {
				update();
				return iterator.next();
			}
		};
	}


	// These are all pretty similar in terms of implementation
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean addAll(Collection arg0) {
		int hashcode=arg0.hashCode()%12;
		
		if(structure.contains(hashcode)==false){
			LinkedList<T> list=new LinkedList<T>();
			list.addAll(arg0);
			structure.add(hashcode,list);
			size++;
		}
		else
			structure.get(hashcode).addAll(arg0);
		
		if(containsAll(arg0)==true)
			return true;
		else
			return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean containsAll(Collection arg0) {
		int hashcode=arg0.hashCode()%12;
		
		if(structure.get(hashcode)==null)
			return false;
		else{
			if(structure.get(hashcode).contains(arg0)==true)
				return true;
			else
				return false;
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean removeAll(Collection arg0) {
		if(contains(arg0)==false) //checks to make sure that the value is in fact in the set in the first place
			return false;
		else{
			int hashcode=arg0.hashCode()%12; //determines the hash code to make sure we get can delete the value
			if(structure.get(hashcode).removeAll(arg0)==true) //this removes the value and will check to make sure it was successful
				return true;
			else
				return false;
		}
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] result=new Object[size];
		
		for(int i=0;i<structure.size();i++) //this should iterate through all of the hash values
			result[i]=structure.get(i).toArray(); //and this should push the linked lists into the array
		
		return result;
	}

	// Don't bother implementing, unless you want to do reflection.
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	// Don't bother implementing.
	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
