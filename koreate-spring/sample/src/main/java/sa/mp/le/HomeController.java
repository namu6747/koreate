package sa.mp.le;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	ArrayList<Board> list;
	
	@GetMapping
	public String home(HttpServletResponse response) throws IOException {
		response.sendRedirect("/le/list");
		return null;
	}
	
	@GetMapping("list")
	public String listPage(Model model) {
		model.addAttribute("list",list);
		return "guestbook/guestbook_list";
	}
	@GetMapping("write")
	public String write(Board board) {
		System.out.println(board);
		if(board != null) {
			list.add(board);
		}
		return "guestbook/guestbook_write";
	}
}
