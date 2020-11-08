package com.mycompany.invoise.api;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }


   @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice, BindingResult results) {
       System.out.println(invoice);
          return   invoiceService.create(invoice);

    }

/*
    @RequestMapping("/home")
    public  ModelAndView displayHome (){
        System.out.println("le controleur à été invoqué par la methode displayHome");
       // List<Invoice> invoices = invoiceService.getInvoiceList();
        ModelAndView mv = new ModelAndView("invoice-home");
        mv.addObject("invoices",invoiceService.getInvoiceList());
        //request.setAttribute("invoices", invoices);
        System.out.println(mv);
        return mv;
    }
*/

    @RequestMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        return invoiceService.getInvoiceById(number);
    }
    
    @GetMapping
    public  List<Invoice> displayHome (){
        System.out.println(invoiceService.getInvoiceList());
        return  invoiceService.getInvoiceList();
    }
    /*
    @GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number,Model model){
        System.out.println("la methode displayInvoice a été invoqué!!");
        //List<Invoice> invoices = invoiceService.getInvoiceList();
        //request.setAttribute("invoices", invoices);
        model.addAttribute("invoice",invoiceService.getInvoiceById(number));
        return "invoice-details";
    }

    @RequestMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){

        return "invoice-create-form";
    }
    @Override
    public String toString() {
        return "InvoiceControllerWeb{" +
                "invoiceService=" + invoiceService +
                '}';
    }
    /*
  */

}
