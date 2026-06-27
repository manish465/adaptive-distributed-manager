export async function getNodes() {
    const response = await fetch("http://localhost:8080/api/v1/cluster/nodes");
    return response.json();
}
