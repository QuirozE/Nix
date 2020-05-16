package com.naat.nix.order.model;

/**
 * Enumeration representing the status of a takeout order.
 * @version 1.0
 */
public enum DeliveryStatus {
  /**
   * Still preparing the order.
   */
  PREPARING,
  /**
   * Order ready to be taken.
   */
  READY,
  
  /**
   * Order in the way.
   */
  DELIVERING,
  
  /**
   * Order already delivered.
   */
  DELIVERED;

  public String toString() {
    var s = "";
    switch(this) {
      case PREPARING: s = "En preparación"; break;
      case READY: s = "Listo para repartición"; break;
      case DELIVERING: s = "En camino"; break;
      case DELIVERED: s = "Entregado"; break;
    }
    return s;
  }
}