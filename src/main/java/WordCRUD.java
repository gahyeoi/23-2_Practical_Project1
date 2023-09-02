import java.util.ArrayList;
import java.util.Scanner;
public class WordCRUD implements ICRUD{
    ArrayList<Word> list ;
    Scanner s;

    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }

    @Override
    public Object add() {
        System.out.print("=> 난이도(1, 2, 3) & 새 단어 입력 : ");
        int level = s.nextInt();
        String word = s.nextLine();

        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning) ;
    }

    @Override
    public int update() {
        return 0;
    }

    @Override
    public int delete() {
        return 0;
    }

    @Override
    public void select() {
    }

    public void listAll(){ //  (1) 모든 단어 보기
        System.out.println("-------------------------------") ;
        for(int i = 0 ; i < list.size(); i++){
            System.out.print(i+1 + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("-------------------------------") ;
    }

    public ArrayList<Integer> listAll(String keyword){
        ArrayList<Integer> idList = new ArrayList<>();
        int j = 0 ;
        System.out.println("-------------------------------") ;
        for(int i = 0 ; i < list.size(); i++){
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue ;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            idList.add(i);
            j++;
        }
        System.out.println("-------------------------------") ;

        return idList;
    }

    public void searchWord(){ // (3) 단어 검색
        System.out.print("=> 검색할 단어 입력 : ");
        String keyword = s.next();

    }
    public void addWord(){ // (4) 단어 추가
        Word word = (Word)add();
        list.add(word) ;
        System.out.println("새 단어가 단어장에 추가되었습니다.");
    }
    public void updateItem(){ // (5) 단어 수정
        System.out.print("=> 수정할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idList = this.listAll(keyword);
        System.out.print("=> 수정할 번호 선택 : ");
        int id = s.nextInt();
        System.out.print("=> 뜻 입력 : ");
        String meaning = s.nextLine();
        Word word = list.get(idList.get(id-1));
        word.setMeaning(meaning);
        System.out.println("단어가 수정되었습니다.");
    }
    public void deleteItem(){ // (6) 단어 삭제
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword = s.next();
        ArrayList<Integer> idList = this.listAll(keyword);
        System.out.print("=> 삭제할 번호 선택 : ");
        int id = s.nextInt();
        System.out.print("=> 정말로 삭제하실래요? (Y/N) ");
        String ans = s.next();
        if(ans.equalsIgnoreCase("Y")){
            list.remove((int)idList.get(id-1));
            System.out.println("단어가 삭제되었습니다.");
        } else{
            System.out.println("취소되었습니다.");
        }
    }
}
