package com.naat.nix.order.controller;

import com.naat.nix.order.model.DeliveryStatus;
import com.naat.nix.order.model.Takeout;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Managing Takeout entity manipulation with the DB.
 */
@Repository
public interface TakeoutRepository extends CrudRepository<Takeout, Long>{

  /**
   * Filtering orders by client
   * @param id
   * @return Iterable of all the client takeout orders.
   */
  Iterable<Takeout> findByClientEmail(String email);

  Iterable<Takeout> findByDeliveryManEmail(String emal);

  Iterable<Takeout> findByStatus(DeliveryStatus status);
}