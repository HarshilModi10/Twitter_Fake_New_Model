from igraph import *

# Open textfile and reduce array of values to 0 based index values
count = 0
node_map = dict()
connections = set()

graph = Graph()

file = 'graph_rep.txt'
file2 = 'graph_data.txt'

with open(file2, 'r') as f:
	for line in f:
		for pair in line.split(";"):
			if not pair: continue
			node_l = int(pair.split(",")[0])
			node_r = int(pair.split(",")[1])
			#print("{}->{}".format(node_l, node_r))
			if node_l not in node_map:
				node_map[node_l] = count
				count += 1
			if node_r not in node_map:
				node_map[node_r] = count
				count += 1
			new_connect = "{}-{}".format(
				min(node_map[node_l],node_map[node_r]),
				max(node_map[node_l],node_map[node_r])
			)
			if new_connect in connections:
				continue
			connections.add(new_connect)
			# Add more verticies if needed
			graph.add_vertices(count - graph.vcount())
			graph.add_edges([(node_map[node_l],node_map[node_r])])

print("Number of nodes:",count)

#layout = graph.layout_kamada_kawai()
#layout = graph.layout_lgl()
#layout = graph.layout_random()
#layout = graph.layout_fruchterman_reingold() # Clean kk
layout = graph.layout_fruchterman_reingold(grid=True) # supa clean
color_dict = {"u": "black", "a": "red"}

graph.vs["state"] = ["u" for i in range(count)]
graph.vs["color"] = [color_dict[state] for state in graph.vs["state"]]

# Initial plot
num_states = 0
out = plot(graph, layout = layout, bbox = (4000, 3000))
out.save('graph_states/graph_state_{}.png'.format(num_states))

# with open('graph_transitions.txt', 'r') as f:
# 	for line in f:
# 		line = [int(p) for p in line.strip().split(',') if p]
# 		#g.vs[0]["gender"] = "m"
# 		for node in line:
# 			graph.vs[node_map[node]]["state"] = "a"

# 		# Update graph with new states
# 		num_states += 1
# 		graph.vs["color"] = [color_dict[state] for state in graph.vs["state"]]
# 		out = plot(graph, layout = layout, margin = 20)
# 		out.save('graph_states/graph_state_{}.png'.format(num_states))

