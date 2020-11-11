package com.mycompany.invoise.invoiceweb.controller;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import com.mycompany.invoise.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb  {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }


   @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult results) {

            if(results.hasErrors()){
                return "invoice-create-form";
            }
            Invoice invoice = new Invoice();
            invoice.setCustomerName(invoiceForm.getCustomerName());
            invoice.setOrderNumber(invoiceForm.getOrderNumber());
            invoiceService.create(invoice);
            return "invoice-created";
    }




    @RequestMapping("/home")
    public ModelAndView displayHome (){
        System.out.println("le controleur à été invoqué par la methode displayHome");
       // List<Invoice> invoices = invoiceService.getInvoiceList();
        ModelAndView mv = new ModelAndView("invoice-home");
        mv.addObject("invoices",invoiceService.getInvoiceList());
        //request.setAttribute("invoices", invoices);
        System.out.println(mv);
        return mv;
    }

/*==
    @RequestMapping("/{id}")
    public ModelAndView displayInvoice(@PathVariable("id") String number){
        System.out.println("la methode displayInvoice a été invoqué!!");
        //List<Invoice> invoices = invoiceService.getInvoiceList();
        //request.setAttribute("invoices", invoices);
        ModelAndView mv = new ModelAndView("invoice-details");
        mv.addObject("invoice",invoiceService.getInvoiceById(number));
        return mv;
    }
*/

/*


    @GetMapping("/home")
    public  String displayHome (Model model){
        System.out.println("le controleur à été invoqué par la methode displayHome");
        // List<Invoice> invoices = invoiceService.getInvoiceList();
        model.addAttribute("invoices",invoiceService.getInvoiceList());
        //request.setAttribute("invoices", invoices);

        return "invoice-home";
    }
    */
   /* @GetMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number,Model model){
        System.out.println("la methode displayInvoice a été invoqué!!");
        //List<Invoice> invoices = invoiceService.getInvoiceList();
        //request.setAttribute("invoices", invoices);
        model.addAttribute("invoice",invoiceService.getInvoiceById(number));
        return "invoice-details";
    }
*/
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
   /* public static void main(String []args){
        InvoiceControllerInterface invoiceController = new InvoiceControllerWeb();
        InvoiceServiceInterface invoiceService = new InvoiceServicePrefix();
        invoiceService.setInvoiceRepository(new InvoiceRepositoryDatabase());
        invoiceController.setInvoiceService(invoiceService);
        invoiceController.createInvoice();
        System.out.println(invoiceController.toString());
    }*/
}
