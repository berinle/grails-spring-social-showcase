class UrlMappings {

  static mappings = {
    "/$controller/$action?/$id?" {
      constraints {
        // apply constraints here
      }
    }

    "/"(controller: "demo", action: "/index")
    "/facebook"(controller: "demo", action: "/fb")
    "/twitter"(controller: "demo", action: "/tw")
    "500"(view: '/error')
  }
}
