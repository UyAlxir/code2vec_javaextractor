import java.io.IOException;
import java.util.ArrayList;

import org.kohsuke.args4j.CmdLineException;

import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;

import JavaExtractor.FeatureExtractor;
import JavaExtractor.Common.CommandLineValues;
import JavaExtractor.FeaturesEntities.ProgramFeatures;
import JavaExtractor.FeaturesEntities.ProgramRelation;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String code="void f(int[] array) {\r\n" + 
				"    boolean swapped = true;\r\n" + 
				"    for (int i = 0; i < array.length && swapped; i++) {\r\n" + 
				"        swapped = false;\r\n" + 
				"        for (int j = 0; j < array.length - 1 - i; j++) {\r\n" + 
				"           if (array[j] > array[j+1]) {\r\n" + 
				"               int temp = array[j];\r\n" + 
				"               array[j] = array[j+1];\r\n" + 
				"               array[j+1]= temp;\r\n" + 
				"               swapped = true;\r\n" + 
				"           }\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"}";
//		String code="System.out.println(\"Hello World\");";
//		System.out.println(code);
		CommandLineValues cmdlval=null;
		try {
			String ars[]= {
					"--max_path_length",
					"8",
					"--max_path_width",
					"2",
					"--no_hash"
			};
			cmdlval = new CommandLineValues(ars);
			
		} catch (CmdLineException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		FeatureExtractor featureExtractor = new FeatureExtractor(cmdlval);
		ProgramRelation.setNoHash();
		try {
			ArrayList<ProgramFeatures> features = featureExtractor.extractFeatures(code);
//			System.out.println(features);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
