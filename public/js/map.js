mapboxgl.accessToken = mapToken

const map = new mapboxgl.Map({
  container: 'map', // Container ID
  style: 'mapbox://styles/mapbox/streets-v12', // Style URL
  center: coordinates, // Starting position [lng, lat]
  zoom: 12 // Starting zoom level
})

const marker1 = new mapboxgl.Marker().setLngLat(coordinates).addTo(map)
