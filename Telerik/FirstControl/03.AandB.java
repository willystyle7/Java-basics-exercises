package Telerik;

import java.util.*;

public class AandB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] token = scan.nextLine().split(" " );
        String element1 = token[0];
        String element2 = token[1];
        Queue<String> variations = new LinkedList<String>();
        variations.add(element1);
        variations.add(element2);
        for (int i = 1; i < n; i++)
        {
            int tempCount = variations.size();
            for (int j = 0; j < tempCount; j++)
            {
                String variant = variations.remove();
                variations.add(variant + element1);
                variations.add(variant + element2);
            }
        }
        ArrayList<String> variationsList = new ArrayList<String>();
        while (variations.size() > 0)
        {
            variationsList.add(variations.remove());
        }
        Collections.sort(variationsList);
        for (String variant : variationsList)
        {
            System.out.println(variant);
        }
    }
}
