package com.BEBW2.ES.EnergyService.Services;

import com.BEBW2.ES.EnergyService.Entities.Invoice;
import com.BEBW2.ES.EnergyService.Entities.InvoiceState;
import com.BEBW2.ES.EnergyService.Exceptions.ByIdNotFoundException;
import com.BEBW2.ES.EnergyService.Exceptions.CantModifyInvoiceException;
import com.BEBW2.ES.EnergyService.Exceptions.InvalidInvoiceStateException;
import com.BEBW2.ES.EnergyService.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository ir;

    public Invoice save(Invoice invoice) {
        return ir.save(invoice);
    }

    public Iterable<Invoice> getAllInvoices() {
        return ir.findAll();
    }

    public Page<Invoice> getAllInvoicesPageable(Pageable p){
        return ir.findAll(p);
    }

    public Invoice getById(Long id) throws ByIdNotFoundException {
        Optional<Invoice> found = ir.findById(id);
        if(found.isPresent()){
            return found.get();
        }
        throw new ByIdNotFoundException("Invoice", id);
    }

    //Update method only works for invoices with state either CREATA or RIFIUTATA
    public Invoice update(Long id, Invoice updtInvoice) throws ByIdNotFoundException, CantModifyInvoiceException {
        Invoice origInvoice = getById(id);
        InvoiceState statoFatt = origInvoice.getStatoFattura();
        if(statoFatt.equals(InvoiceState.CREATA) || statoFatt.equals(InvoiceState.RIFIUTATA)){
            origInvoice.setCustomer(updtInvoice.getCustomer());
            origInvoice.setDate(updtInvoice.getDate());
            origInvoice.setImporto(updtInvoice.getImporto());
            origInvoice.setNumero(updtInvoice.getNumero());
            origInvoice.setStatoFattura(InvoiceState.CREATA);
            ir.save(origInvoice);
            return origInvoice;
        }else{
            throw new CantModifyInvoiceException();
        }
    }

    //modify the invoice state and keep persistence
    public Invoice changeStatus(Long id, InvoiceState newState) throws ByIdNotFoundException {
        Invoice found = getById(id);
        found.setStatoFattura(newState);
        ir.save(found);
        return found;
    }

    //method to change the invoice status to ACCETTATA only if the previous status was INVIATA
    public Invoice acceptInvoice(Long id) throws ByIdNotFoundException, InvalidInvoiceStateException {
        Invoice found = getById(id);
        if(found.getStatoFattura().equals(InvoiceState.INVIATA)){
            found.setStatoFattura(InvoiceState.ACCETTATA);
            ir.save(found);
            return found;
        }else{
            throw new InvalidInvoiceStateException("INVIATA");
        }
    }

    //method to change the invoice status to RIFIUTATA only if the previous status was INVIATA
    public Invoice denyInvoice(Long id) throws ByIdNotFoundException, InvalidInvoiceStateException {
        Invoice found = getById(id);
        if(found.getStatoFattura().equals(InvoiceState.INVIATA)){
            found.setStatoFattura(InvoiceState.RIFIUTATA);
            ir.save(found);
            return found;
        }else{
            throw new InvalidInvoiceStateException("INVIATA");
        }
    }


    //delete invoice by id
    public String delete(Long id){
        ir.deleteById(id);
        return "Invoice deleted successfully.";
    }
}
