import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Comparator;

import java.lang.reflect.Field;

class Automobile {
    
    String name; 
    Integer price;
    Integer milesPerGallon;        
    
    public Automobile(String name_, Integer price_, Integer milesPerGallon_)
    {
        name = name_;
        price = price_;
        milesPerGallon = milesPerGallon_;
    }
    
    public boolean equals(Object obj) { 
        if (obj instanceof Automobile)
        {
            Automobile auto = (Automobile) obj;
            return auto.name != null && auto.name.equals(name) &&
                   auto.price != null && auto.price.equals(price) &&
                   auto.milesPerGallon != null && auto.milesPerGallon.equals(milesPerGallon);
        }
        return false;
    }
                      
    /* Sorter is a nested class to provide sorting functionality for 
       Automobile objects using the Comparator interface.
    */
       
    static public class Sorter implements Comparator<Automobile> {
        
        String sortBy;
        boolean asc;
            
        public int compare(Automobile o1, Automobile o2) {
            
            /*
            use reflection to get the field by name as a more flexible technique
            since we can expand Automobile with more sortable fields, without having to 
            possibly modify this code.
            */
                              
            Field fld1 = null, fld2 = null;            
            Object val1 = null, val2 = null;
            
            try
            {
                fld1 = o1.getClass().getDeclaredField(sortBy);
                fld2 = o2.getClass().getDeclaredField(sortBy);
                val1 = fld1.get(o1);
                val2 = fld2.get(o2);
            }
            catch (Exception e)
            {
                //oops... invalid field, if so then fld1 == null and diff == 0
            }
                        
            //return > 1 if o1 > o2, < 1 if o1 < o2, 0 if o1 == o2
            
            int diff = 0; //undetermined would be equal to 0
            
            if (val1 instanceof String)            
                diff =  ((String) val1).compareTo((String) val2);
                        
            else if (val1 instanceof Integer)            
                diff = (Integer) val1 - (Integer) val2;                
            
            //else undetermined so diff = 0
            
            //ascending if fld1 > fld2 <==> diff > 0, if fld1 == fld2 <==> diff == 0
            return asc ? diff : -diff;
        }
        
        //not relevant for sorting but is required for implementation of Comparator
        public boolean equals(Object obj) { 
            return false;
        }
        
        static final Automobile[] ARRAY = new Automobile[0];
        
        static List<Automobile> sort(Collection<Automobile> autos, String sortBy, Boolean asc) {
            
            Sorter sorter =  new Sorter();
            sorter.sortBy = sortBy;
            sorter.asc = asc;
            
            Automobile[] array = autos.toArray(ARRAY);
            
            //sort the array using the Java Arrays class
            Arrays.sort(array, sorter);
            
            return Arrays.asList(array);
        }
    }
}

