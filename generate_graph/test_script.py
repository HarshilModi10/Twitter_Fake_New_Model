from igraph import *
from time import sleep
# g = Graph()
# g.add_vertices(3)
# g.add_edges([(0,1),(1,0),(1,2),(2,0)])
# print(g)

# # repear add
# g.add_edges([(0,1),(1,0),(1,2),(2,0)])
# print(g)

# # Use a deterministic generator
# g = Graph.Tree(127, 2)
# summary(g)

# Graphs are in order
# vs -> vertex sequence
# es -> edge sequence
g = Graph([(0,1), (0,2), (2,3), (3,4), (4,2), (2,5), (5,0), (6,3), (5,6)])
g.vs["name"] = ["Alice", "Bob", "Claire", "Dennis", "Esther", "Frank", "George"]
g.vs["age"] = [25, 31, 18, 47, 22, 23, 50]
g.vs["gender"] = ["f", "m", "f", "m", "f", "m", "m"]
g.es["is_formal"] = [False, False, True, True, True, False, True, False, False]

# Can change atributes
g.es[0].attributes()
g.es[0]["is_formal"] = True
g.es[0].attributes()

print(g)

layout = g.layout_kamada_kawai()
#layout = g.layout_reingold_tilford(root=2)
# plot(g, layout=layout)
# sleep(1)
# g.add_edges([(0,7),(9,3)])
# plot(g, layout=layout)
# sleep(1)
# g.add_edges([(0,8),(3,9)])
# plot(g, layout=layout)
# sleep(1)

g.vs["label"] = g.vs["name"]
color_dict = {"m": "blue", "f": "red"}
g.vs["color"] = [color_dict[gender] for gender in g.vs["gender"]]
plot(g, layout = layout, margin = 20)
print("\n",g.vs["gender"])
g.vs[0]["gender"] = "m"
print("\n",g.vs["gender"])
g.vs["color"] = [color_dict[gender] for gender in g.vs["gender"]]
#sleep(1)
plot(g, layout = layout, margin = 20)

# Graph will look same each time if all processed at once!
# out = igraph.plot(g)
# out.save(name + '_allyBetweenness.png')