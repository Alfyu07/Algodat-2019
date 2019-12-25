//import StackQueue.*;
//
//
//public class sharah {
//    static int priority(char operator){
//        if ( operator == '+' || operator == '-' ){
//            return 1;
//        } else if ( operator == '*' || operator == '/' ){
//            return 2;
//        } else if ( operator == '^' ){
//            return 3;
//        } return 0;
//    }
//    static String intoPostfix( String question ){
//        Stack operator = new Stack();
//        String resultPos = "";
//        String tmp = "";
//        //    String question = "(A*B+D-J)*C";
//        for ( char current : question.toCharArray() ){
//            if ( current == '+' || current == '*' || current == '/' || current == '-' || current == '^' ){
//                while ( operator.getTop() != null && priority(operator.getTop().nama.charAt(0)) >= priority(current) ){
//                    resultPos += operator.popString();
//                }
//                tmp = "";
//                tmp += current;
//                operator.push(tmp);
//            }
//            else if ( current == '(' ){
//                tmp = "";
//                tmp += current;
//                operator.push(tmp);
//            } else if ( current == ')' ){
//                while(operator.getTop() != null && operator.getTop().nama.charAt(0) != '(' ){
//                    resultPos += operator.popString();
//                } operator.popString();
//            } else {
//                resultPos += current;
//            }
//        }
//        while ( operator.getTop() != null ){
//            resultPos += operator.popString();
//        } return resultPos;
//    }
//    static void intoPrefix( String question ){
//        Stack pref = new Stack();
//        String tmpo = "";
//        String resultPre = "";
//        for ( char current : question.toCharArray() ){
//            if ( current == '+' || current == '*' || current == '/' || current == '-' || current == '^' ){
//                String opr1 = pref.popString();
//                String opr2 = pref.popString();
//                tmpo = "";
//                tmpo += current;
//                tmpo += opr2;
//                tmpo += opr1;
//                pref.push(tmpo);
//            } else {
//                tmpo = "";
//                tmpo += current;
//                pref.push(tmpo);
//            }
//
//        }
//        System.out.println("Prefix : "+pref.getTop().nama);
//        System.out.println("Prefix : "+resultPre);
//        // ;
//        // resultPre = tmpo.getTop().chara;
//        //   return resultPre;
//    }
//    public static void main(String[] args) {
//        String question = "(A*B+D-J)*C";
//        String hasil = intoPostfix(question);
//        System.out.println("Postfix : "+hasil);
//        // System.out.println("Postfix : "+intoPrefix(hasil));
//        intoPrefix(hasil);
//    }
//}