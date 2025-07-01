package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/books")
@Transactional
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(
        value = "/books/{id}/selectbestseller",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Book selectBestSeller(
        @PathVariable(value = "id") Long id,
        @RequestBody SelectBestSellerCommand selectBestSellerCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /book/selectBestSeller  called #####");
        Optional<Book> optionalBook = bookRepository.findById(id);

        optionalBook.orElseThrow(() -> new Exception("No Entity Found"));
        Book book = optionalBook.get();
        book.selectBestSeller(selectBestSellerCommand);

        bookRepository.save(book);
        return book;
    }
}
//>>> Clean Arch / Inbound Adaptor
