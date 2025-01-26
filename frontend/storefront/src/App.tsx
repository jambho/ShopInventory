import { useState, useEffect } from 'react'

import './App.css'

function App() {
  const [parts, setParts] = useState([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    const fetchParts = async () => {
      console.log('fetching parts')
      const response = await fetch('http://localhost:8080/api/parts')
      const data = await response.json()
      setParts(data)
      setLoading(false)
    }

    fetchParts()
  }, [])

  return (
    <>
      <h1>Parts</h1>
      {loading ? (
        <p>Loading...</p>
      ) : (
        <ul>
          {parts.map((part: any) => (
            <li key={part.id}>
              {part.partName} - {part.partPrice}
            </li>
          ))}
        </ul>
      )}
    </>
  )
}

export default App
