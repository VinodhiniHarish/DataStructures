/**
 * File Name: SlistMergeSort.java 
 * Sort int slist using Merge Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java SlistSort.java SlistMergeSort.java
 */

class SlistMergeSort extends SlistSort{
  //You can add any number of private members to this class
  //You can add any number of private functions to this class
 
  @Override
  protected void sort(boolean ascend) {
    //WRITE CODE HERE
    //YOU CAN CALL ANY OF YOUR PRIVATE FUNCTION 
   IntSlist2 l = sortAsc(this.a);
   if(l!=null)
   {
	   a.first = l.first;
   }
  }
  
  public static IntSlist2 sortAsc(IntSlist2 a) {
	  int n = a.size();
	  if(n < 2)
		  return null;
	  int mid = n/2;
	  node temp = a.first;
	  IntSlist2 left = new IntSlist2();
	  IntSlist2 right = new IntSlist2();
	  node left_last = null,right_last =null;
	  for(int i=0;i<mid;i++) {
		  left_last = left.add(temp.d, temp.t, left_last);
		  temp = temp.next;
	  }
	  for(int j=mid;j<(n);j++) {
		  right_last = right.add(temp.d, temp.t, right_last);
		  temp =  temp.next;
	  }
	  sortAsc(left);
	  sortAsc(right);
	  IntSlist2 t = merge(left,right,a);
	  a.first = t.first;
	  return a;
  }
  
  public static IntSlist2 merge(IntSlist2 left, IntSlist2 right, IntSlist2 a) {
	  a = new IntSlist2();
	  node left_ptr = left.first;
	  node right_ptr = right.first;
	  node last = null;
	  
	  while(left_ptr!=null && right_ptr!=null) {
		  if(left_ptr.d <= right_ptr.d) {
			  last = a.add(left_ptr.d,left_ptr.t,last);
			  left_ptr = left_ptr.next;
		  }else if(right_ptr.d < left_ptr.d) {
			  last = a.add(right_ptr.d,right_ptr.t,last);
			  right_ptr=right_ptr.next;
		  }
	  }
	  while(left_ptr!=null) {
		  last = a.add(left_ptr.d,left_ptr.t,last);
		  left_ptr = left_ptr.next;
	  }
	  while(right_ptr!=null) {
		  last = a.add(right_ptr.d,right_ptr.t,last);
		  right_ptr=right_ptr.next;
	  }
	  return a;
  }
  
  public static void main(String[] args) {
    System.out.println("SlistMergeSort.java");
    SlistMergeSort u = new SlistMergeSort() ;
    u.testBench();
    System.out.println("SlistMergeSort.java Done. You are genius");
  }
}


