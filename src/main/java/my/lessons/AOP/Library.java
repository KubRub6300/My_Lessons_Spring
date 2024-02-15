package my.lessons.AOP;

import org.springframework.stereotype.Component;

@Component
public class Library {
    public Book getBook(){
        System.out.println("Берём книгу");
        Book book = new Book();
        book.setName("Фор фан");
        book.setAuthor("Мама мия");
        return book;
    }

    public void getBook(String bookName) {
        System.out.println("Берём книгу " + bookName);
    }

    public void getBook(Book book){
        System.out.println("Берём книгу " + book.getName());
    }

    public void returnBook() throws Exception {
        System.out.println("Возвращаем книгу");
        throw new Exception("Вээ Вээ Вэээ Ошибка!");
    }
    public boolean addBook(String username, Book book){
        System.out.println("Добавляем книгу");
        return true;
    }
}
