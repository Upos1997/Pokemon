public abstract class Effect {
   private Source source;
   private Effect next;

   protected Effect(Source source){
      this.source = source;
}
   
   private abstract boolean doEffect(Field field);

   private boolean hasNext(){
     return next != null;
}
   public void setNext(Effect newNext){
      next = newNext;
}

   public Source getSource(){
      return source;
}

   public void execute(Field field){
     if (doEffect() && hasNext()) {
        next.execute(field)      
}
}
}
