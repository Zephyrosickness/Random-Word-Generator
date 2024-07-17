import java.util.Random;
public class gen {
    display display = new display();
    public static String generate(int length, int vowelDistance, String startLetter){
        String[] vowels = {"a","e","i","o","u"};
        String[] consonants = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
        String[] all = {"A","E","I","O","U","B","C","D","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};
        String finalWord = "";

        if(startLetter=="Any Letter"){
            finalWord = randomize(all);
        }else if(startLetter == "Any Consonant"){
            finalWord = randomize(consonants);
        }else if(startLetter == "Any Vowel"){
            finalWord = randomize(vowels);
        }else{
            finalWord = startLetter;
        }

        //inserts random letters until the length is met
        for(int i = 0; finalWord.length()<length;){
            for(int j = 1; j<=vowelDistance; j++){
                finalWord = finalWord+randomize(consonants);

                //inserts a vowel after voweldistance is met (for example, if voweldistance is 2, only add a vowel every 2 letters)
                if(j==vowelDistance&&finalWord.length()<length){
                    finalWord = finalWord+randomize(vowels);
                }
            }
        }
        System.out.println(finalWord);
        return finalWord;
    }

    public static String randomize(String[] array){

        Random rand = new Random();
        int resultIndex = rand.nextInt(array.length);
        if(resultIndex==0){
            resultIndex = 1;
        }
        return array[resultIndex];

    }
}
