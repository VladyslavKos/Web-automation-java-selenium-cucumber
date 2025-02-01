package Learning;

public class SecondDay {
   public static Integer number1;
    public static void main(String[] args){

        try{
            test2(null);
        } catch (StringNumberException e) {
            throw new RuntimeException("Exeption caughty: "+e);
        }
    }

    public static  void test2(Integer number) throws StringNumberException{
        if (number==null){
            throw new StringNumberException("Lol this realy working?");
        }
    }
}
class StringNumberException extends Exception{
    StringNumberException(String exception){
        super(exception);
    }
}

//        try{
//            int s = number1 / 0;
//        } catch (ArithmeticException e) {
//            System.out.println("Lol are you for real?");
//        }catch (NullPointerException e){
//            throw new NullPointerException("Message  "+ e);
//        }finally {
//           System.out.println("Database was dropped");
//        }