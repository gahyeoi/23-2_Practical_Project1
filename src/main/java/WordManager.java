import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;

    WordManager(){
        wordCRUD = new WordCRUD(s);
    }
    public int selectMenu() {
        System.out.println("""
                *********************
                1. 모든 단어 보기
                2. 수준별 단어 보기
                3. 단어 검색
                4. 단어 추가
                5. 단어 수정
                6. 단어 삭제
                7. 파일 저장
                8. 단어 퀴즈
                0. 나가기
                *********************
                => 원하는 메뉴는?\s"""
        );
        return s.nextInt();
    }

    public void start(){
        wordCRUD.loadFile();
        while(true) {
            int menu = selectMenu();
            if (menu == 0) break;

            switch (menu) {
                case 1 -> wordCRUD.listAll();
                case 2 -> wordCRUD.searchLevel();
                case 3 -> wordCRUD.searchWord();
                case 4 -> wordCRUD.addWord();
                case 5 -> wordCRUD.updateWord();
                case 6 -> wordCRUD.deleteWord();
                case 7 -> wordCRUD.saveFile();
                case 8 -> wordCRUD.wordQuiz();
                default -> System.out.println("0~7 사이 메뉴를 입력해주세요");
            }
        }
    }
}
