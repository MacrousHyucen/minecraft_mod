import lib, recipes


# wand
for cap in lib.caps.values():
    for rod in lib.rods.values():
        if (rod[1] != 'primal'):
            recipes.make_wand_recipe(rod, cap)

# scepter
for cap in lib.caps.values():
    for rod in lib.rods.values():
        if (rod[1] != 'primal'):
            recipes.make_scepter_recipe(rod, cap)

# staff
for cap in lib.caps.values():
    for rod in lib.rods.values():
        if (rod[1] != 'wood'):
            recipes.make_staff_recipe(rod, cap)

# staff
for cap in lib.caps.values():
    for rod in lib.rods.values():
        if (rod[1] != 'primal') and (rod[1] != 'wood'):
            recipes.make_staffcore_recipe(rod, cap)