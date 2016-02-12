package com.example.ojas.governanceapp;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;


public class GeneratorDAO {

    public static void main (String args[]) throws Exception {
        Schema schema = new Schema(1,"com.com.example.ojas.governanceapp.ojas.governanceapp.example.example.model");

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
        plot.addStringProperty("center_point_type");
        plot.addDoubleProperty("cp_coord_latitude");
        plot.addDoubleProperty("cp_coord_longitude");
        plot.addShortProperty("reported_shape"); //TODO confirm datatype
        plot.addShortProperty("mapped_shape"); //TODO confirm datatype
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
        plot.addStringProperty("fileName");
        plot.addStringProperty("image_file_path"); // local only
        plot.addStringProperty("photo_direction");
        plot.addDateProperty("photo_date");

        Entity aeq = schema.addEntity("aeq");
        aeq.addIdProperty();
        aeq.addStringProperty("name");
        aeq.addStringProperty("region");
        aeq.addStringProperty("species");
        aeq.addBooleanProperty("volumetric");

        Property plotID = aeq.addLongProperty("plotID").getProperty();
        aeq.addToOne(plot, plotID);
        ToMany plotToAeq = plot.addToMany(aeq, plotID);
        plotToAeq.setName("aeq");

        new DaoGenerator().generateAll(schema, "../app/src/main/java");
    }
}
