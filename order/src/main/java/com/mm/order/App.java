package com.mm.order;

import com.mm.run.DefaultMain;

public class App extends DefaultMain {

  public static void main(String[] args) {
    run(new OrderVerticle());
  }

}
