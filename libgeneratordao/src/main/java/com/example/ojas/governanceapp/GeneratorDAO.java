package com.example.ojas.governanceapp;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;


public class GeneratorDAO {

    public static void string (String args[]) throws Exception {
        Schema schema = new Schema(1,"com.com.example.ojas.governanceapp.ojas.governanceapp.model");

        Entity plot = schema.addEntity("Plot");
        plot.addIdProperty();
        plot.addStringProperty("url");
        plot.addIntProperty("parcel");
        plot.addIntProperty("project");
        plot.addStringProperty("name");
        plot.addStringProperty("default_aeq"); //TODO confirm datatype
        plot.addBooleanProperty("calculate_by_species");
        plot.addStringProperty("region");
        plot.addFloatProperty("root_to_shoot_ratio");
        plot.addStringProperty("mapped_dimensions"); //TODO confirm datatype
        plot.addStringProperty("reported_dimensions"); //TODO confirm datatype
        plot.addByteProperty("reported_shape"); //TODO confirm datatype
        plot.addByteProperty("mapped_shape"); //TODO confirm datatype
        plot.addBooleanProperty("has_soil_data");
        plot.addBooleanProperty("has_biomass_data");
        plot.addBooleanProperty("has_deadwood_data");
        plot.addBooleanProperty("has_litter_data");
        plot.addFloatProperty("mapped_area");
        plot.addFloatProperty("reported_area");
        plot.addFloatProperty("area");
        plot.addIntProperty("tree_species_count");
        plot.addIntProperty("tree_count");

        //image handling

        plot.addStringProperty("image_file_path"); // local only

        Entity center_point = schema.addEntity("center_point");
        center_point.addStringProperty("type");
        //TODO add property for coordinates

        Entity aeq = schema.addEntity("aeq");
        aeq.addIdProperty();
        aeq.addStringProperty("name");
        aeq.addStringProperty("region");
        aeq.addStringProperty("species");
        aeq.addBooleanProperty("volumetric");

    }
}
