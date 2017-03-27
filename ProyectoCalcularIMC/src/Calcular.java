
public class Calcular {

	
	
	   public static float calcularIMC(Double peso,Double altura)
	      {
	    	 float imc=0;
	    	   imc=(float) (peso/(altura*altura));
	    	  return imc;
	      }
	   public static String mostrarResultadoIMC(float imc)
	      {
		   String res=null;

	  		
	  		if (imc < 16)
	  		{
	  			res="ES desmutrido";
	  		   
	  		}
	  		else if (16 <=imc && imc<18.5)
	  		{
	  			res="Es bajopeso";
	  		
	  		}
	  		else  if (imc>=18 && imc <25)
	  		{	res="normal";
	  	    	
	  		}
	  		else if (imc>=25 && imc <30)
	  		{		res="sobrepeso";

	  		}
	  		else if (imc>=30)  // podemos quetar el (imc>=30)
	  		{ res="obeso";
	  		
	  	    }
	  		
	  		return res;
	      }
	      
}
