package com.naat.nix.menu.controller;

import java.util.Set;

import javax.annotation.PostConstruct;

import com.naat.nix.menu.model.Category;
import com.naat.nix.menu.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuInitialization {

  @Autowired
  private CategoryRepository categoryDao;

  @Autowired
  private FoodRepository foodDao;

  @PostConstruct
  public void addMenu() {
    // Algunas categorías
    var aperitivos = new Category("Aperitivos"); categoryDao.save(aperitivos);
    var ensaladas = new Category("Ensaladas"); categoryDao.save(ensaladas);
    var entradas = new Category("Entradas"); categoryDao.save(entradas);
    var guarniciones = new Category("Guarniciones"); categoryDao.save(guarniciones);
    var bebidas = new Category("Bebidas"); categoryDao.save(bebidas);

    // Algunos platillos
    // Aperitivos
    var aperitivosItems = Set.of (
      new Food("Guacamole","Salsa mexicana preparada a base de aguacate y chile verde o chile pimiento","semper.tiff",30,aperitivos),
      new Food("Papas a la francesa","Papas cortadas en rodajas y freidas en aceite","hac_habitasse.png",30,aperitivos),
      new Food("Brocheta de frutas","Bolitas de melón, sandía y plátano en un palo","volutpat_in.png",40,aperitivos),
      new Food("Tabla de quesos","Tabla con diversos quesos para compartir","eget_semper.tiff",60,aperitivos),
      new Food("Ensaladilla rusa","Platillo típico con papas y hortalizas","odio_cras_mi.tiff",35,aperitivos)
    );
    foodDao.saveAll(aperitivosItems);

    // Ensaladas
    var ensaladasItems = Set.of (
      new Food("César","Ensalada de lechuga romana y croûtons con jugo de limón, aceite de oliva, huevo, salsa Worcestershire, anchoas, ajo, mostaza de Dijon, queso parmesano y pimienta negra","donec_odio.gif",60,ensaladas),
      new Food("Mediterránea","Ensalada con ingredientes característicos de la zona del mediterráneo.","eget_semper.jpeg",55,ensaladas),
      new Food("De pollo","Ensalada César con pollo.","augue_a.png",65,ensaladas)
    );
    foodDao.saveAll(ensaladasItems);

    // Entradas
    var entradasItems = Set.of(
      new Food("Consomé","Clásica receta de consomé de pollo.","nibh_fusce_lacus.jpeg",70,entradas),
      new Food("Sopa de fideo","Con pollo.","justo_aliquam.gif",69,entradas),
      new Food("Sope sencillo","Con frijoles, lechuga, cebolla y queso","at_turpis.jpeg",36,entradas),
      new Food("Tostada sencilla","Con frijoles, lechuga, cebolla y queso","pellentesque_volutpat_dui.png",50,entradas),
      new Food("Queso fundido","160 gramos de queso manchego fundido.","justo_sollicitudin.tiff",80,entradas),
      new Food("Quesadilla","Quesadilla de queso.","erat_curabitur_gravida.tiff",30,entradas)
    );
    foodDao.saveAll(entradasItems);

    // Guarniciones
    var guarnicionesItems = Set.of(
      new Food("Pollo con mole","Platillo de pollo con mole. Incluye tortillas.","lacinia_aenean_sit.jpeg",80,guarniciones),
      new Food("Fajitas de pollo","Pollo asado a la parrilla cortado en tiras y servido en tortilla de harina.","malesuada_in_imperdiet.jpeg",180,guarniciones),
      new Food("Fajitas de arrachera","Arrachera asada a la parrilla cortada en tiras y servida en tortilla de harina.","ornare_consequat_lectus.png",205,guarniciones),
      new Food("Gringas","Tortilla de harina rellena de queso, al pastor y piña.","fusce.tiff",95,guarniciones),
      new Food("Burrito","Tortilla de harina enrollada con carne, queso, frijoles, jitomate y cebolla.","rhoncus_mauris_enim.tiff",100,guarniciones),
      new Food("Taco de Suadero","Con tortilla hecha a mano, cebolla y cilantro.","rhoncus.tiff",20,guarniciones),
      new Food("Taco de Pastor","Con tortilla hecha a mano, cebolla y cilantro.","lacinia_aenean_sit.jpeg",20,guarniciones),
      new Food("Taco de Bistec","Con tortilla hecha a mano, cebolla y cilantro.","lacy.jpeg",20,guarniciones)
    );
    foodDao.saveAll(guarnicionesItems);

    var bebidasItems = Set.of(
      new Food("Agua de horchata","1/2 litro.","",40, bebidas),
      new Food("Agua de jamaica","1/2 litro","",40, bebidas),
      new Food("Refresco","350 mL.","",30, bebidas),
      new Food("Limonada","1 litro.","",45, bebidas)
    );
    foodDao.saveAll(bebidasItems);
  }
}