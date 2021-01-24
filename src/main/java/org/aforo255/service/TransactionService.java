package org.aforo255.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.aforo255.entity.Transaction;
import org.aforo255.repository.TransactionRepository;

@ApplicationScoped
public class TransactionService  implements ITransactionService{

	@Inject
	TransactionRepository repository ; 
	
	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		transaction.persist();
		return transaction;
	}

	@Override
	public Transaction findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
