package com.mall.management.Controller;

import com.mall.management.DTO.ProductDTO;
import com.mall.management.Entity.Product;
import com.mall.management.Service.ProductSerice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class ProductController {
    private final ProductSerice productSerice;

    //시작페이지
    @GetMapping("/")
    public String index() {
        return "index";
    }

    //목록
    @GetMapping("product/list")
    public String productlist(Model model) throws Exception {
        List<Product> lists = productSerice.findAll();
        model.addAttribute("lists",lists);
        return "product/list";
    }

    //상세보기
    @GetMapping("product/view")
    public String productview(int pno, Model model) throws Exception {
        ProductDTO data = productSerice.findByPno(pno);
        model.addAttribute("data",data);
        return "product/view";
    }

    //삽입
    @GetMapping("product/insert")
    public String productinsert() throws Exception {
        return "product/insert";
    }
    @PostMapping("product/insert")
    public String productinsertpost(ProductDTO productDTO) throws Exception {
        int pno = productSerice.insert(productDTO);

        return "redirect:/";
    }

    //수정
    @GetMapping("product/update")
    public String productupdate(int pno, Model model) throws Exception {
        ProductDTO productDTO = productSerice.findByPno(pno);
        model.addAttribute("data", productDTO);
        return "product/update";
    }
    @PostMapping("product/update")
    public String productupdatepost(@ModelAttribute("productDTO") ProductDTO productDTO, RedirectAttributes redirectAttributes) {
        productSerice.update(productDTO);
        redirectAttributes.addAttribute("pno",productDTO.getPno());
        redirectAttributes.addAttribute("pname",productDTO.getPname());
        redirectAttributes.addAttribute("quan",productDTO.getQuan());
        redirectAttributes.addAttribute("price",productDTO.getPrice());
        redirectAttributes.addAttribute("pdate",productDTO.getPdate());

        return "redirect:/";
    }

    //삭제처리
    @GetMapping("product/delete")
    public String productdelete(int pno, RedirectAttributes redirectAttributes) {
        productSerice.delete(pno);
        redirectAttributes.addAttribute("msg",pno);
        return "redirect:/";
    }

}
