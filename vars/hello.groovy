def call(Map config = [:]) {
  // Check if name and dayOfWeek are provided
  if (!config.name || !config.dayOfWeek) {
    error 'Name and dayOfWeek are required.'
  }

  // Validate dayOfWeek
  def validDays = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
  if (!validDays.contains(config.dayOfWeek)) {
    error "Invalid dayOfWeek: ${config.dayOfWeek}. Must be one of: ${validDays.join(', ')}."
  }

  // Validate name
  if (!config.name?.trim()) {
    error 'Name cannot be empty.'
  }

  sh "echo Hello ${config.name}. Today is ${config.dayOfWeek}."
}
