lazy val deepLearning = project.disablePlugins(SparkPackagePlugin).dependsOn(differentiable)

lazy val differentiable = project.disablePlugins(SparkPackagePlugin).dependsOn(dsl)

lazy val dsl = project.disablePlugins(SparkPackagePlugin)