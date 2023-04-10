package stars.astral.moonlib;

import com.cryptomorin.xseries.XMaterial;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import stars.astral.moonlib.schematic.Schematic;

import java.io.File;
import java.io.IOException;

public final class MoonLib extends JavaPlugin {

    private File schematicFolder;

    @Override
    public void onEnable() {
        // Plugin startup logic
        schematicFolder = new File(getDataFolder(), "schematics");
        if (!schematicFolder.exists()) {
            schematicFolder.mkdirs();
        }

        File exampleSchematic = new File(schematicFolder, "example.schem");
        if (exampleSchematic.exists()) {
            Schematic schematic = new Schematic(exampleSchematic, "example");
            schematic.addToScanIndex(XMaterial.RED_GLAZED_TERRACOTTA);
            schematic.addToScanIndex(XMaterial.SPRUCE_LOG);
            schematic.addToScanIndex(XMaterial.OAK_LOG);
            try {
                schematic.paste(getServer().getWorld("world"), new Location(getServer().getWorld("world"), 0, 100, 0), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Scanned Map Size: " + schematic.getScannedMap().size());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
