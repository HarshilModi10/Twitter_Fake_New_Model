from igraph import *

# Global variables for mapping of graph nodes
count = 0
node_map = dict()
connections = set()

graph = Graph()

# File -> The graph initial state with connections
file = 'graph_rep.txt'
# File2 -> The newly affected nodes after each iteration
file2 = 'graph_transitions.txt'

# Open textfile and reduce array of values to 0 based index values
with open(file, 'r') as f:
	for line in f:
		for pair in line.split(";"):
			if not pair: continue
			node_l = int(pair.split(",")[0])
			node_r = int(pair.split(",")[1])
			
			if node_l not in node_map:
				node_map[node_l] = count
				count += 1

			if node_r not in node_map:
				node_map[node_r] = count
				count += 1

			# Undirected graph representation ensured with this portion 
			new_connect = "{}-{}".format(
				min(node_map[node_l],node_map[node_r]),
				max(node_map[node_l],node_map[node_r])
			)

			if new_connect in connections:
				continue

			# Add new connection to the set of connections
			connections.add(new_connect)

			# Add more verticies if needed and then create the edge
			graph.add_vertices(count - graph.vcount())
			graph.add_edges([(node_map[node_l],node_map[node_r])])

print("Number of nodes:",count)


'''
GRAPHING OPTIONS:
layout_lgl()
layout_kamada_kawai()
layout_fruchterman_reingold() -- Cleaner version of kk
layout_fruchterman_reingold(grid=True) -- TODO: Determine how to get grid to work
'''
layout = graph.layout_random()

color_dict = {"u": "black", "a": "red"}

graph.vs["state"] = ["u" for i in range(count)]
graph.vs["color"] = [color_dict[state] for state in graph.vs["state"]]

# Initial plot
num_states = 0
out = plot(graph, layout = layout, bbox = (4000, 3000))
out.save('graph_states/graph_state_{}.png'.format(num_states))

# Perform graph node color transition based on updated graph states in textfile
with open(file2, 'r') as f:
	for line in f:
		line = [int(p) for p in line.strip().split(',') if p]
		
		for node in line:
			graph.vs[node_map[node]]["state"] = "a"

		# Update graph with new states and increment state transition count
		num_states += 1
		graph.vs["color"] = [color_dict[state] for state in graph.vs["state"]]

		# Display and save images to folder
		out = plot(graph, layout = layout, bbox = (4000, 3000))
		out.save('graph_states/graph_state_{}.png'.format(num_states))

