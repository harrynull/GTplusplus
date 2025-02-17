package gtPlusPlus.xmod.gregtech.common.items;

import static gregtech.api.enums.Textures.BlockIcons.*;
import static gregtech.client.GT_TooltipHandler.Tier.*;
import static gregtech.client.GT_TooltipHandler.registerTieredTooltip;
import static gtPlusPlus.core.util.Utils.getTcAspectStack;

import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.enums.TC_Aspects;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.objects.GT_MultiTexture;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_ModHandler;
import gregtech.common.covers.GT_Cover_Arm;
import gregtech.common.covers.GT_Cover_Conveyor;
import gregtech.common.covers.GT_Cover_Pump;
import gregtech.common.items.behaviors.Behaviour_DataOrb;
import gregtech.common.items.behaviors.Behaviour_DataStick;
import gtPlusPlus.api.objects.Logger;
import gtPlusPlus.core.lib.CORE;
import gtPlusPlus.core.util.Utils;
import gtPlusPlus.core.util.data.StringUtils;
import gtPlusPlus.core.util.math.MathUtils;
import gtPlusPlus.core.util.minecraft.ItemUtils;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechOrePrefixes;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechOrePrefixes.GT_Materials;
import gtPlusPlus.xmod.gregtech.api.items.Gregtech_MetaItem_X32;
import gtPlusPlus.xmod.gregtech.common.blocks.textures.TexturesGtBlock;
import gtPlusPlus.xmod.gregtech.common.covers.GTPP_Cover_Overflow;

public class MetaGeneratedGregtechItems extends Gregtech_MetaItem_X32 {

    public static final MetaGeneratedGregtechItems INSTANCE;

    static {
        INSTANCE = new MetaGeneratedGregtechItems();
    }

    public MetaGeneratedGregtechItems() {
        super("MU-metaitem.01", new OrePrefixes[] { null });
    }

    public void generateMetaItems() {
        int tLastID = 0;

        registerCustomCircuits();

        // Simplify life.
        registerComponents_ULV();

        // Extruder Shape
        GregtechItemList.Shape_Extruder_WindmillShaft
                .set(this.addItem(tLastID = 40, "Extruder Shape (Shaft)", "Extruder Shape for making Windmill Shafts"));

        // Batteries
        GregtechItemList.Battery_RE_EV_Sodium.set(
                this.addItem(
                        tLastID = 50,
                        "Quad Cell Sodium Battery",
                        "Reusable",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 2L),
                                getTcAspectStack(TC_Aspects.METALLUM, 2L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 2L) }));
        this.setElectricStats(32000 + tLastID, 3200000L, GT_Values.V[4], 4L, -3L, true);
        registerTieredTooltip(GregtechItemList.Battery_RE_EV_Sodium.get(1), EV);

        GregtechItemList.Battery_RE_EV_Cadmium.set(
                this.addItem(
                        tLastID = 52,
                        "Quad Cell Cadmium Battery",
                        "Reusable",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.METALLUM, 1L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 1L) }));
        this.setElectricStats(32000 + tLastID, 4800000L, GT_Values.V[4], 4L, -3L, true);
        registerTieredTooltip(GregtechItemList.Battery_RE_EV_Cadmium.get(1), EV);

        GregtechItemList.Battery_RE_EV_Lithium.set(
                this.addItem(
                        tLastID = 54,
                        "Quad Cell Lithium Battery",
                        "Reusable",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 3L),
                                getTcAspectStack(TC_Aspects.METALLUM, 3L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 3L) }));
        this.setElectricStats(32000 + tLastID, 6400000L, GT_Values.V[4], 4L, -3L, true);
        registerTieredTooltip(GregtechItemList.Battery_RE_EV_Lithium.get(1), EV);

        /**
         * Power Gems
         */
        GregtechItemList.Battery_Gem_1.set(
                this.addItem(
                        tLastID = 66,
                        "Proton Cell",
                        "Reusable",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 8L),
                                getTcAspectStack(TC_Aspects.METALLUM, 24L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 16L) }));
        this.setElectricStats(32000 + tLastID, GT_Values.V[6] * 20 * 300 / 4, GT_Values.V[6], 6L, -3L, false);
        GregtechItemList.Battery_Gem_2.set(
                this.addItem(
                        tLastID = 68,
                        "Electron Cell",
                        "Reusable",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 16L),
                                getTcAspectStack(TC_Aspects.METALLUM, 32L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 32L) }));
        this.setElectricStats(32000 + tLastID, GT_Values.V[7] * 20 * 300 / 4, GT_Values.V[7], 7L, -3L, false);
        GregtechItemList.Battery_Gem_3.set(
                this.addItem(
                        tLastID = 70,
                        "Quark Entanglement",
                        "Reusable",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 32L),
                                getTcAspectStack(TC_Aspects.METALLUM, 48L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 64L) }));
        this.setElectricStats(32000 + tLastID, GT_Values.V[8] * 20 * 300 / 4, GT_Values.V[8], 8L, -3L, false);
        // ItemUtils.addItemToOreDictionary(GregtechItemList.Battery_Gem_1.get(1), "batteryFutureBasic");
        // ItemUtils.addItemToOreDictionary(GregtechItemList.Battery_Gem_2.get(1), "batteryFutureGood");
        // ItemUtils.addItemToOreDictionary(GregtechItemList.Battery_Gem_3.get(1), "batteryFutureAdvanced");

        /*
         * GregtechItemList.Battery_RE_EV_Sodium.set(addItem(tLastID = 50, "Quad Cell Acid Battery", "Reusable", new
         * Object[]{getTcAspectStack(TC_Aspects.ELECTRUM, 1L), getTcAspectStack(TC_Aspects.METALLUM, 1L),
         * getTcAspectStack(TC_Aspects.POTENTIA, 1L)})); setElectricStats(32000 + tLastID, 5000000L, GT_Values.V[2], 4L,
         * -3L, true); GregtechItemList.Battery_RE_EV_Sodium.set(addItem(tLastID = 50, "Quad Cell Mercury Battery",
         * "Reusable", new Object[]{getTcAspectStack(TC_Aspects.ELECTRUM, 1L), getTcAspectStack(TC_Aspects.METALLUM,
         * 1L), getTcAspectStack(TC_Aspects.POTENTIA, 1L)})); setElectricStats(32000 + tLastID, 5000000L,
         * GT_Values.V[2], 4L, -3L, true);
         */

        // RTG Pellet
        GregtechItemList.Pellet_RTG_PU238.set(
                this.addItem(
                        41,
                        StringUtils.superscript("238") + "Pu Pellet",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.RADIO, 4L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 2L),
                                getTcAspectStack(TC_Aspects.METALLUM, 2L) }));
        GregtechItemList.Pellet_RTG_SR90.set(
                this.addItem(
                        42,
                        StringUtils.superscript("90") + "Sr Pellet",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.RADIO, 4L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 2L),
                                getTcAspectStack(TC_Aspects.METALLUM, 2L) }));
        GregtechItemList.Pellet_RTG_PO210.set(
                this.addItem(
                        43,
                        StringUtils.superscript("210") + "Po Pellet",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.RADIO, 4L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 2L),
                                getTcAspectStack(TC_Aspects.METALLUM, 2L) }));
        GregtechItemList.Pellet_RTG_AM241.set(
                this.addItem(
                        44,
                        StringUtils.superscript("241") + "Am Pellet",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.RADIO, 4L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 2L),
                                getTcAspectStack(TC_Aspects.METALLUM, 2L) }));

        CORE.RA.addFuelForRTG(GregtechItemList.Pellet_RTG_PU238.get(1), MathUtils.roundToClosestInt(87.7f), 64);
        CORE.RA.addFuelForRTG(GregtechItemList.Pellet_RTG_SR90.get(1), MathUtils.roundToClosestInt(28.8f), 32);
        CORE.RA.addFuelForRTG(GregtechItemList.Pellet_RTG_PO210.get(1), 1, 512);
        CORE.RA.addFuelForRTG(GregtechItemList.Pellet_RTG_AM241.get(1), MathUtils.roundToClosestInt(432 / 2), 16);
        CORE.RA.addFuelForRTG(GT_ModHandler.getIC2Item("RTGPellets", 1), MathUtils.roundToClosestInt(2.6f), 8);

        // Computer Cube
        GregtechItemList.Gregtech_Computer_Cube.set(
                this.addItem(
                        tLastID = 55,
                        "Gregtech Computer Cube",
                        "Reusable",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 8L),
                                getTcAspectStack(TC_Aspects.METALLUM, 8L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 8L) }));
        this.setElectricStats(32000 + tLastID, GT_Values.V[6] * 10 * 60 * 20, GT_Values.V[5], 5L, -3L, true);

        GregtechItemList.Cover_Overflow_ULV.set(
                this.addItem(
                        71,
                        "Overflow Valve (ULV)",
                        "Maximum void amount: 8,000",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.ITER, 1L),
                                getTcAspectStack(TC_Aspects.AQUA, 1L) }));
        GregtechItemList.Cover_Overflow_LV.set(
                this.addItem(
                        72,
                        "Overflow Valve (LV)",
                        "Maximum void amount: 64,000",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.ITER, 1L),
                                getTcAspectStack(TC_Aspects.AQUA, 1L) }));
        GregtechItemList.Cover_Overflow_MV.set(
                this.addItem(
                        73,
                        "Overflow Valve (MV)",
                        "Maximum void amount: 512,000",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.ITER, 1L),
                                getTcAspectStack(TC_Aspects.AQUA, 1L) }));
        GregtechItemList.Cover_Overflow_HV.set(
                this.addItem(
                        74,
                        "Overflow Valve (HV)",
                        "Maximum void amount: 4,096,000",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.ITER, 1L),
                                getTcAspectStack(TC_Aspects.AQUA, 1L) }));
        GregtechItemList.Cover_Overflow_EV.set(
                this.addItem(
                        75,
                        "Overflow Valve (EV)",
                        "Maximum void amount: 32,768,000",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.ITER, 1L),
                                getTcAspectStack(TC_Aspects.AQUA, 1L) }));
        GregtechItemList.Cover_Overflow_IV.set(
                this.addItem(
                        76,
                        "Overflow Valve (IV)",
                        "Maximum void amount: 262,144,000",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.ITER, 1L),
                                getTcAspectStack(TC_Aspects.AQUA, 1L) }));

        GregTech_API.registerCover(
                GregtechItemList.Cover_Overflow_ULV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[4][0],
                                new GT_RenderedTexture(TexturesGtBlock.Overlay_Overflow_Valve) }),
                new GTPP_Cover_Overflow(8));
        GregTech_API.registerCover(
                GregtechItemList.Cover_Overflow_LV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[4][0],
                                new GT_RenderedTexture(TexturesGtBlock.Overlay_Overflow_Valve) }),
                new GTPP_Cover_Overflow(64));
        GregTech_API.registerCover(
                GregtechItemList.Cover_Overflow_MV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[5][0],
                                new GT_RenderedTexture(TexturesGtBlock.Overlay_Overflow_Valve) }),
                new GTPP_Cover_Overflow(512));
        GregTech_API.registerCover(
                GregtechItemList.Cover_Overflow_HV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[5][0],
                                new GT_RenderedTexture(TexturesGtBlock.Overlay_Overflow_Valve) }),
                new GTPP_Cover_Overflow(4096));
        GregTech_API.registerCover(
                GregtechItemList.Cover_Overflow_EV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[8][0],
                                new GT_RenderedTexture(TexturesGtBlock.Overlay_Overflow_Valve) }),
                new GTPP_Cover_Overflow(32768));
        GregTech_API.registerCover(
                GregtechItemList.Cover_Overflow_IV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[8][0],
                                new GT_RenderedTexture(TexturesGtBlock.Overlay_Overflow_Valve) }),
                new GTPP_Cover_Overflow(262144));

        // Fusion Reactor MK4 Singularity
        GregtechItemList.Compressed_Fusion_Reactor.set(
                this.addItem(
                        100,
                        "Hypervisor Matrix (Fusion)",
                        "A memory unit containing an RI (Restricted Intelligence)"));

        GregtechItemList.Laser_Lens_Special
                .set(this.addItem(105, "Quantum Anomaly", "Probably should shoot it with lasers"));

        GregtechItemList.Battery_Casing_Gem_1.set(this.addItem(106, "Containment Unit I", "Used in crafting"));
        GregtechItemList.Battery_Casing_Gem_2.set(this.addItem(107, "Containment Unit II", "Used in crafting"));
        GregtechItemList.Battery_Casing_Gem_3.set(this.addItem(108, "Advanced Containment Unit", "Used in crafting"));
        GregtechItemList.Battery_Casing_Gem_4.set(this.addItem(109, "Exotic Containment Unit", "Used in crafting"));

        GregtechItemList.Battery_Gem_4.set(
                this.addItem(
                        tLastID = 110,
                        "Graviton Anomaly",
                        "Reusable",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 64L),
                                getTcAspectStack(TC_Aspects.METALLUM, 64L),
                                getTcAspectStack(TC_Aspects.POTENTIA, 64L) }));
        this.setElectricStats(32000 + tLastID, (64000000000L * 16), GT_Values.V[9], 9L, -3L, false);

        /*
         * Bombs
         */
        GregtechItemList.Bomb_Cast.set(this.addItem(111, "Bomb Cast", "Used in the production of Bombs"));
        GregtechItemList.Bomb_Cast_Molten.set(this.addItem(112, "Bomb Cast (Hot)", "Consider cooling this off"));
        GregtechItemList.Bomb_Cast_Set
                .set(this.addItem(113, "Bomb Cast (Set)", "Break it open for the goodies inside!"));
        GregtechItemList.Bomb_Cast_Broken.set(this.addItem(114, "Bomb Cast (Broken)", "This is probably just junk"));
        GregtechItemList.Bomb_Cast_Mold.set(this.addItem(115, "Mold (Bomb Cast)", "Used in the production of Bombs"));

        /*
         * High Tier 'Saws' for the tree Farm
         */

        GregtechItemList.Laser_Lens_WoodsGlass.set(
                this.addItem(
                        140,
                        "Wood's Glass Lens",
                        "Allows UV & IF to pass through, blocks visible light spectrums"));

        int aStartID = 141;
        GregtechItemList[] aTransParts = new GregtechItemList[] { GregtechItemList.TransmissionComponent_ULV,
                GregtechItemList.TransmissionComponent_LV, GregtechItemList.TransmissionComponent_MV,
                GregtechItemList.TransmissionComponent_HV, GregtechItemList.TransmissionComponent_EV,
                GregtechItemList.TransmissionComponent_IV, GregtechItemList.TransmissionComponent_LuV,
                GregtechItemList.TransmissionComponent_ZPM, GregtechItemList.TransmissionComponent_UV,
                GregtechItemList.TransmissionComponent_MAX, };
        for (int aIndex = 0; aIndex < 10; aIndex++) {
            aTransParts[aIndex].set(
                    this.addItem(
                            aStartID++,
                            "Transmission Component (" + GT_Values.VN[aIndex] + ")",
                            "",
                            new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, aIndex),
                                    getTcAspectStack(TC_Aspects.MACHINA, aIndex),
                                    getTcAspectStack(TC_Aspects.MAGNETO, aIndex) }));
        }

        // Distillus Chip
        GregtechItemList.Distillus_Upgrade_Chip
                .set(this.addItem(151, "Distillus Upgrade Chip", "Used to upgrade Distillus to Tier 2"));
        GregtechItemList.Maceration_Upgrade_Chip
                .set(this.addItem(152, "Maceration Upgrade Chip", "Used to upgrade Maceration Stack to Tier 2"));
    }

    private boolean registerComponents_ULV() {
        GregtechItemList.Electric_Pump_ULV.set(
                this.addItem(
                        32,
                        "Electric Pump (ULV)",
                        "160 L/sec (as Cover)",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.ITER, 1L),
                                getTcAspectStack(TC_Aspects.AQUA, 1L) }));
        GregtechItemList.Electric_Motor_ULV.set(
                this.addItem(
                        33,
                        "Electric Motor (ULV)",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.MOTUS, 1L) }));
        GregtechItemList.Conveyor_Module_ULV.set(
                this.addItem(
                        34,
                        "Conveyor Module (ULV)",
                        "1 Stack every 80 secs (as Cover)",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.ITER, 1L) }));
        GregtechItemList.Electric_Piston_ULV.set(
                this.addItem(
                        35,
                        "Electric Piston (ULV)",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 2L), getTcAspectStack(TC_Aspects.MOTUS, 1L) }));
        GregtechItemList.Robot_Arm_ULV.set(
                this.addItem(
                        36,
                        "Robot Arm (ULV)",
                        "Inserts into specific Slots (as Cover)",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 2L), getTcAspectStack(TC_Aspects.MOTUS, 1L),
                                Utils.getTcAspectStack("COGNITIO", 1L) }));
        GregtechItemList.Field_Generator_ULV.set(
                this.addItem(
                        37,
                        "Field Generator (ULV)",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 2L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.TUTAMEN, 1L) }));
        GregtechItemList.Emitter_ULV.set(
                this.addItem(
                        38,
                        "Emitter (ULV)",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.LUX, 1L) }));
        GregtechItemList.Sensor_ULV.set(
                this.addItem(
                        39,
                        "Sensor (ULV)",
                        "",
                        new Object[] { getTcAspectStack(TC_Aspects.ELECTRUM, 1L),
                                getTcAspectStack(TC_Aspects.MACHINA, 1L), getTcAspectStack(TC_Aspects.SENSUS, 1L) }));

        GregTech_API.registerCover(
                GregtechItemList.Electric_Pump_ULV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[5][0],
                                new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PUMP) }),
                new GT_Cover_Pump(8, TextureFactory.of(OVERLAY_PUMP)));
        GregTech_API.registerCover(
                GregtechItemList.Conveyor_Module_ULV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[1][0],
                                new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_CONVEYOR) }),
                new GT_Cover_Conveyor(1600, 1, TextureFactory.of(OVERLAY_CONVEYOR)));
        GregTech_API.registerCover(
                GregtechItemList.Robot_Arm_ULV.get(1L),
                new GT_MultiTexture(
                        new ITexture[] { Textures.BlockIcons.MACHINE_CASINGS[1][0],
                                new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_ARM) }),
                new GT_Cover_Arm(1600, TextureFactory.of(OVERLAY_ARM)));

        return true;
    }

    public boolean registerOldCircuits() {
        // Enable Old Circuits
        Logger.INFO("[Old Feature - Circuits] Enabling Pre-5.09.28 Circuits and Data Storage.");

        GregtechItemList.Old_Circuit_Primitive.set(
                this.addItem(
                        200,
                        "NAND Chip",
                        "A very simple Circuit",
                        new Object[] { OrePrefixes.circuit.get(Materials.Primitive) }));
        GregtechItemList.Old_Circuit_Basic.set(
                this.addItem(
                        201,
                        "Basic Electronic Circuit",
                        "A basic Circuit",
                        new Object[] { OrePrefixes.circuit.get(Materials.Basic) }));
        GregtechItemList.Old_Circuit_Good.set(
                this.addItem(
                        202,
                        "Good Electronic Circuit",
                        "A good Circuit",
                        new Object[] { OrePrefixes.circuit.get(Materials.Good) }));
        GregtechItemList.Old_Circuit_Advanced.set(
                this.addItem(
                        203,
                        "Advanced Circuit",
                        "An advanced Circuit",
                        new Object[] { OrePrefixes.circuit.get(Materials.Advanced) }));
        GregtechItemList.Old_Circuit_Data.set(
                this.addItem(
                        204,
                        "Data Storage Circuit",
                        "A Data Storage Chip",
                        new Object[] { OrePrefixes.circuit.get(Materials.Data) }));
        GregtechItemList.Old_Circuit_Elite.set(
                this.addItem(
                        205,
                        "Data Control Circuit",
                        "A Processor",
                        new Object[] { OrePrefixes.circuit.get(Materials.Elite) }));
        GregtechItemList.Old_Circuit_Master.set(
                this.addItem(
                        206,
                        "Energy Flow Circuit",
                        "A High Voltage Processor",
                        new Object[] { OrePrefixes.circuit.get(Materials.Master) }));

        GregtechItemList.Old_Tool_DataOrb.set(
                this.addItem(
                        207,
                        "Data Orb [GT++]",
                        "A High Capacity Data Storage",
                        new Object[] { OrePrefixes.circuit.get(Materials.Ultimate), SubTag.NO_UNIFICATION,
                                new Behaviour_DataOrb() }));
        GregtechItemList.Old_Circuit_Ultimate.set(GregtechItemList.Old_Tool_DataOrb.get(1L));
        GT_ModHandler.addShapelessCraftingRecipe(
                GregtechItemList.Old_Tool_DataOrb.get(1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { GregtechItemList.Old_Tool_DataOrb.get(1L) });

        GregtechItemList.Old_Tool_DataStick.set(
                this.addItem(
                        208,
                        "Data Stick [GT++]",
                        "A Low Capacity Data Storage",
                        new Object[] { OrePrefixes.circuit.get(Materials.Data), SubTag.NO_UNIFICATION,
                                new Behaviour_DataStick() }));
        GT_ModHandler.addShapelessCraftingRecipe(
                GregtechItemList.Old_Tool_DataStick.get(1L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { GregtechItemList.Old_Tool_DataStick.get(1L) });

        GregtechItemList.Old_Circuit_Board_Basic.set(this.addItem(210, "Basic Circuit Board", "A basic Board"));
        GregtechItemList.Old_Circuit_Board_Advanced
                .set(this.addItem(211, "Advanced Circuit Board", "An advanced Board"));
        GregtechItemList.Old_Circuit_Board_Elite.set(this.addItem(212, "Processor Board", "A Processor Board"));
        GregtechItemList.Old_Circuit_Parts_Crystal_Chip_Elite
                .set(this.addItem(213, "Engraved Crystal Chip", "Needed for Circuits"));
        GregtechItemList.Old_Circuit_Parts_Crystal_Chip_Master
                .set(this.addItem(214, "Engraved Lapotron Chip", "Needed for Circuits"));
        GregtechItemList.Old_Circuit_Parts_Advanced
                .set(this.addItem(215, "Advanced Circuit Parts", "Advanced Circuit Parts"));
        GregtechItemList.Old_Circuit_Parts_Wiring_Basic
                .set(this.addItem(216, "Etched Medium Voltage Wiring", "Part of Circuit Boards"));
        GregtechItemList.Old_Circuit_Parts_Wiring_Advanced
                .set(this.addItem(217, "Etched High Voltage Wiring", "Part of Circuit Boards"));
        GregtechItemList.Old_Circuit_Parts_Wiring_Elite
                .set(this.addItem(218, "Etched Extreme Voltage Wiring", "Part of Circuit Boards"));
        GregtechItemList.Old_Empty_Board_Basic.set(this.addItem(219, "Empty Circuit Board", "A Board Part"));
        GregtechItemList.Old_Empty_Board_Elite
                .set(this.addItem(220, "Empty Processor Board", "A Processor Board Part"));

        return true;
    }

    public boolean registerCustomCircuits() {
        if (CORE.ConfigSwitches.enableCustomCircuits) {
            GregtechItemList.Circuit_IV.set(
                    this.addItem(
                            704,
                            "Symbiotic Circuit (IV)",
                            "A Symbiotic Data Processor",
                            new Object[] { GregtechOrePrefixes.circuit.get(GT_Materials.Symbiotic) }));
            GregtechItemList.Circuit_LuV.set(
                    this.addItem(
                            705,
                            "Neutronic Circuit (LuV)",
                            "A Neutron Particle Processor",
                            new Object[] { GregtechOrePrefixes.circuit.get(GT_Materials.Neutronic) }));
            GregtechItemList.Circuit_ZPM.set(
                    this.addItem(
                            706,
                            "Quantum Circuit (ZPM)",
                            "A Singlularity Processor",
                            new Object[] { GregtechOrePrefixes.circuit.get(GT_Materials.Quantum) }));
            GregtechItemList.Circuit_Board_IV
                    .set(this.addItem(710, "IV Circuit Board", "An IV Voltage Rated Circuit Board"));
            GregtechItemList.Circuit_Board_LuV
                    .set(this.addItem(711, "LuV Circuit Board", "An LuV Voltage Rated Circuit Board"));
            GregtechItemList.Circuit_Board_ZPM
                    .set(this.addItem(712, "ZPM Processor Board", "A ZPM Voltage Rated Processor Board"));
            GregtechItemList.Circuit_Parts_Crystal_Chip_IV
                    .set(this.addItem(713, "(IV) Energized Crystal Chip", "Needed for Circuits"));
            GregtechItemList.Circuit_Parts_Crystal_Chip_LuV
                    .set(this.addItem(714, "(LuV) Neutron based Microchip", "Needed for Circuits"));
            GregtechItemList.Circuit_Parts_Crystal_Chip_ZPM
                    .set(this.addItem(715, "(ZPM) Quantum Chip", "Needed for Circuits"));
            GregtechItemList.Circuit_Parts_IV.set(this.addItem(716, "(IV) Energized Circuit Parts", "Circuit Parts"));
            GregtechItemList.Circuit_Parts_LuV
                    .set(this.addItem(717, "(LuV) Neutron-based Circuit Parts", "Circuit Parts"));
            GregtechItemList.Circuit_Parts_ZPM.set(this.addItem(718, "(ZPM) Quantum Circuit Parts", "Circuit Parts"));
            GregtechItemList.Circuit_Parts_Wiring_IV
                    .set(this.addItem(719, "Etched IV Voltage Wiring", "Part of Circuit Boards"));
            GregtechItemList.Circuit_Parts_Wiring_LuV
                    .set(this.addItem(720, "Etched LuV Voltage Wiring", "Part of Circuit Boards"));
            GregtechItemList.Circuit_Parts_Wiring_ZPM
                    .set(this.addItem(721, "Etched ZPM Voltage Wiring", "Part of Circuit Boards"));
            ItemUtils.addItemToOreDictionary(GregtechItemList.Circuit_IV.get(1), "circuitSuperconductor");
            ItemUtils.addItemToOreDictionary(GregtechItemList.Circuit_LuV.get(1), "circuitInfinite");
            return true;
        }
        return false;
    }
}
