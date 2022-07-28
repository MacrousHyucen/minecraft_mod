import json
from math import floor
import os
import lib

def make_wand_recipe(rod, cap):
    name = f'wand_{rod[1]}_{cap[1]}'
    dicti = {}

    if (not os.path.isdir("wand_recipes")):
        os.mkdir("wand_recipes")

    dicti["type"] = "thaumcraft:vis_shaped"
    dicti["pattern"] = [
        "  c", 
        " r ", 
        "c  "
    ]
    rod_item = "minecraft:stick" if rod[1] == 'wood' else f"thaumcraft:wand_{rod[0]}"
    dicti["key"] = {
        "c": {"item": f"thaumcraft:{cap[0]}"},
        "r": {"item": rod_item}
    }

    vis_discount = 0.8
    type_quant = 1
    rod_quant = int(rod[2]) - 25
    cap_quant = (1.0 + cap[2] / 2) if cap[2] > 0 else 1.0
    vis_amount = floor(rod_quant * type_quant * vis_discount * cap_quant)
    dicti["vis"] = {k:vis_amount for k in lib.aspects}

    dicti["result"] = {
        "item": f"thaumcraft:{name}"
    }

    with open(f"wand_recipes/{name}.json", "w") as outfile:
        json.dump(dicti, outfile, indent=2)

def make_scepter_recipe(rod, cap):
    name = f'scepter_{rod[1]}_{cap[1]}'
    dicti = {}

    if (not os.path.isdir("scepter_recipes")):
        os.mkdir("scepter_recipes")

    dicti["type"] = "thaumcraft:vis_shaped"
    dicti["pattern"] = [
        " cp", 
        " rc", 
        "c  "
    ]
    rod_item = "minecraft:stick" if rod[1] == 'wood' else f"thaumcraft:wand_{rod[0]}"
    dicti["key"] = {
        "p": {"item": "thaumcraft:primal_charm"},
        "c": {"item": f"thaumcraft:{cap[0]}"},
        "r": {"item": rod_item}
    }

    vis_discount = 0.8
    type_quant = 1.25
    rod_quant = rod[2] - (25 / 2)
    cap_quant = (1.0 + cap[2] / 2) if cap[2] > 0 else 1.0
    vis_amount = floor(rod_quant * cap_quant * type_quant * vis_discount)
    dicti["vis"] = {k:vis_amount for k in lib.aspects}

    dicti["result"] = {
        "item": f"thaumcraft:{name}"
    }

    with open(f"scepter_recipes/{name}.json", "w") as outfile:
        json.dump(dicti, outfile, indent=2)

def make_staff_recipe(rod, cap):
    name = f'staff_{rod[1]}_{cap[1]}'
    dicti = {}

    if (not os.path.isdir("staff_recipes")):
        os.mkdir("staff_recipes")

    dicti["type"] = "thaumcraft:vis_shaped"
    dicti["pattern"] = [
        "  c", 
        " r ", 
        "c  "
    ]
    rod_item = "minecraft:stick" if rod[1] == 'wood' else f"thaumcraft:staff_{rod[0]}"
    dicti["key"] = {
        "c": {"item": f"thaumcraft:{cap[0]}"},
        "r": {"item": rod_item}
    }

    vis_discount = 0.8
    type_quant = 1.25
    rod_quant = rod[2] - (25 / 2)
    cap_quant = (1.0 + cap[2] / 2) if cap[2] > 0 else 1.0
    vis_amount = floor(rod_quant * cap_quant * type_quant * vis_discount)
    dicti["vis"] = {k:vis_amount for k in lib.aspects}

    dicti["result"] = {
        "item": f"thaumcraft:{name}"
    }

    with open(f"staff_recipes/{name}.json", "w") as outfile:
        json.dump(dicti, outfile, indent=2)

def make_staffcore_recipe(rod, cap):
    name = f"staff_{rod[0]}"
    dicti = {}

    if (not os.path.isdir("staff_rod_recipes")):
        os.mkdir("staff_rod_recipes")

    dicti["type"] = "thaumcraft:vis_shaped"
    dicti["pattern"] = [
        "  p", 
        " r ", 
        "r  "
    ]

    rod_item = "minecraft:stick" if rod[1] == 'wood' else f"thaumcraft:wand_{rod[0]}"
    dicti["key"] = {
        "p": {"item": "thaumcraft:primal_charm"},
        "r": {"item": rod_item}
    }

    vis_discount = 0.6
    rod_quant = rod[2]
    vis_amount = floor(rod_quant * vis_discount)
    dicti["vis"] = {k:vis_amount for k in lib.aspects}

    dicti["result"] = {
        "item": f"thaumcraft:{name}"
    }
    
    with open(f"staff_rod_recipes/{name}.json", "w") as outfile:
        json.dump(dicti, outfile, indent=2)
