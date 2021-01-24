package org.aforo255.service;

import org.aforo255.entity.Transaction;

public interface ITransactionService {
	public Transaction save (Transaction transaction);
	public Transaction findById (Integer id );
}
