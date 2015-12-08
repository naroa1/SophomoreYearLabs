package labs;

// http://en.wikipedia.org/wiki/Binary_heap
public class BinaryHeap<T extends Comparable<T>> {
	BinaryTree<T> tree = new BinaryTree<T>();
	// Insert an element into the binary heap
	// Not a one-liner
	public void insert (T item) {
		int addedPosition=0; //used for items greater than the root node
		int currentSize; //used for items less than the root node
		T temp; //used to perform data swaps
		
		if(tree.get(0)==null){ //if the tree is empty, we just add in the item freely
			tree.add(item);
		}
		
		else{ //otherwise we have some checks we have to perform!
			
			if(tree.get(0).compareTo(item)>0){ //the item being added is less than root node
				currentSize=tree.add(item);
				if(tree.get(tree.parent(currentSize)).compareTo(tree.get(currentSize))<0) //checks to see if the new child is greater than its parent
				{
					temp=tree.get(tree.parent(currentSize)); //if it is, then we swap the parent with the child
					tree.set(tree.parent(currentSize),tree.get(currentSize));
					tree.set(currentSize,temp);
				}
			}
			
			else if(tree.get(0).compareTo(item)<=0){ //the item being added is greater than or equal to root node
				//here, we'll add the item and do several parent/child swaps until we reach the root
				addedPosition=tree.add(item);
				
				while(tree.get(addedPosition).compareTo(tree.get(tree.parent(addedPosition)))>0){ //continues while parents are less than their children
					if(tree.get(addedPosition).compareTo(tree.get(tree.parent(addedPosition)))>0){ //checks to see if the child is greater than its parent
						temp=tree.get(tree.parent(addedPosition)); //holds on to parent value
						tree.set(tree.parent(addedPosition), tree.get(addedPosition)); //sets parent value to child value
						tree.set(addedPosition,temp); //sets child value to old parent value
					}
					addedPosition=tree.parent(addedPosition);
					//since it isn't a problem if a node is less than it's parent, we don't need to address that case
					//same applies to if a node is equal to its parent
				}
			}
		}
	}
	// Only remove the root (not a one-liner)
	public T remove () {
		int counter=1; //used to iterate through the heap
		T max=tree.get(counter); //sets the max to the first non-root node just for comparison's sake
		T removed=tree.get(0); //holds the value of what we're removing to return it once it's completed
		
		while(tree.get(counter)!=null){ //this while loop compares each node to the max
			if(tree.get(counter).compareTo(max)>0){
				max=tree.get(counter); //if the max is less than current node, then max becomes current node
			}
			counter++;
		}
		
		//moving the new max up
		int maxPosition=tree.search(max);
		T temp; //used for clean value swaps
		
		if((tree.get(maxPosition*2+1)==null||tree.get(maxPosition*2+2)==null)){ //0 or 1 kids from max node
			tree.set(0,tree.get(maxPosition));
			if(tree.get(maxPosition*2+1)==null)
				tree.set(maxPosition, tree.get(maxPosition*2+1));
			else if (tree.get(maxPosition*2+2)==null)
				tree.set(maxPosition, tree.get(maxPosition*2+2));
			else
				tree.set(maxPosition,null);
		}
		
		else{ //2 kids from max node
			temp=tree.get(maxPosition); //holds on to the value at the max position
			tree.set(maxPosition, tree.get(counter-1)); //swaps the last added value with the max position
			tree.set(counter-1,temp); //finishes the swap
			
			tree.set(0, tree.get(counter-1)); //swaps the value in the root node with the new max
			tree.set(counter-1, null); //eradicates the evidence!
		}
		return removed;
	}
	// Does the heap have the item?
	public boolean contains (T item) {
		if(tree.get(0).compareTo(item)<0) //if the item we're checking for is greater than the root, we're already done
			return false;
		else if (tree.get(0).compareTo(item)==0) //if the item is equal to the root, then there it is!
			return true;
		else if (tree.get(0).compareTo(item)>0){ //if the item is less than the root, now we've gotta perform a search
			if(tree.search(item)!=-1)
				return true;
			else
				return false;
		}
			
		return false; //default case, though it really shouldn't ever be encountered
	}
}
