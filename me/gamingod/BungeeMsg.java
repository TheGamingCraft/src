package me.gamingod;

import java.util.HashMap;
import java.util.Map;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMsg extends Plugin
  implements Listener
{
	
	private Map<String, String> messagers = new HashMap<String, String>();
	
  public void onEnable()
  {
    getProxy().getPluginManager().registerListener(this, this);
    getProxy().getPluginManager().registerCommand(this, new Command("msg")
    {
        public void execute(CommandSender sender, String[] args) {
        	  if (args.length == 0) {
        		  sender.sendMessage(ChatColor.RED + "Usage: /msg <player> <message>");
        	  } else if (args.length == 1) {
        		  sender.sendMessage(ChatColor.RED + "Usage: /msg <player> <message>");
        	  } else {
        		  
        		  if (!(sender instanceof ProxiedPlayer)) {
        			  
        			  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Proxy support coming soon");
        			  
        		  } else {
        			  
        			  if (args[0].equals(sender.getName())) {
        				  
        				  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You cannot send message to yourself");
        				  
        			  } else {
        		  
                  StringBuilder str = new StringBuilder();
                  for (int i = 1; i < args.length; i++) {
                          str.append(args[i] + " ");
                  }
                  String message = str.toString();
                  ProxiedPlayer p1 = getProxy().getPlayer(args[0]);
                  if (p1 != null) {
                  sender.sendMessage(ChatColor.LIGHT_PURPLE + "To " + args[0] + ": " + ChatColor.RESET + message);
        		  p1.sendMessage(ChatColor.LIGHT_PURPLE + "From " + sender.getName() + ": " + ChatColor.RESET + message);
        		messagers.put(p1.getName(), sender.getName());
                  } else {
                	  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Could not find player " + args[0]);
                  }
        		 }
        		}
        	  }
          }
        
    });
    getProxy().getPluginManager().registerCommand(this, new Command("tell") {
        public void execute(CommandSender sender, String[] args) {
        	  if (args.length == 0) {
        		  sender.sendMessage(ChatColor.RED + "Usage: /tell <player> <message>");
        	  } else if (args.length == 1) {
        		  sender.sendMessage(ChatColor.RED + "Usage: /tell <player> <message>");
        	  } else {
        		  
        		  if (!(sender instanceof ProxiedPlayer)) {
        			  
        			  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Proxy support coming soon");
        			  
        		  } else {
        			  
        			  if (args[0].equals(sender.getName())) {
        				  
        				  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You cannot send message to yourself");
        				  
        			  } else {
        		  
                  StringBuilder str = new StringBuilder();
                  for (int i = 1; i < args.length; i++) {
                          str.append(args[i] + " ");
                  }
                  String message = str.toString();
                  ProxiedPlayer p1 = getProxy().getPlayer(args[0]);
                  if (p1 != null) {
                  sender.sendMessage(ChatColor.LIGHT_PURPLE + "To " + args[0] + ": " + ChatColor.RESET + message);
        		  p1.sendMessage(ChatColor.LIGHT_PURPLE + "From " + sender.getName() + ": " + ChatColor.RESET + message);
        		messagers.put(p1.getName(), sender.getName());
                  } else {
                	  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Could not find player " + args[0]);
                  }
        		 }
        		}
        	  }
          }
        });
    getProxy().getPluginManager().registerCommand(this, new Command("w") {
        public void execute(CommandSender sender, String[] args) {
      	  if (args.length == 0) {
      		  sender.sendMessage(ChatColor.RED + "Usage: /w <player> <message>");
      	  } else if (args.length == 1) {
      		  sender.sendMessage(ChatColor.RED + "Usage: /w <player> <message>");
      	  } else {
      		  
      		  if (!(sender instanceof ProxiedPlayer)) {
      			  
      			  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Proxy support coming soon");
      			  
      		  } else {
      			  
      			  if (args[0].equals(sender.getName())) {
      				  
      				  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You cannot send message to yourself");
      				  
      			  } else {
      		  
                StringBuilder str = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                        str.append(args[i] + " ");
                }
                String message = str.toString();
                ProxiedPlayer p1 = getProxy().getPlayer(args[0]);
                if (p1 != null) {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "To " + args[0] + ": " + ChatColor.RESET + message);
      		  p1.sendMessage(ChatColor.LIGHT_PURPLE + "From " + sender.getName() + ": " + ChatColor.RESET + message);
      		messagers.put(p1.getName(), sender.getName());
                } else {
              	  sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Could not find player " + args[0]);
                }
      		 }
      		}
      	  }
        }
      });
    getProxy().getPluginManager().registerCommand(this, new Command("r") {
        public void execute(CommandSender sender, String[] args) {
        	if (args.length == 0) {
        		
        		sender.sendMessage(ChatColor.RED + "Usage: /r <message>");
        		
        	} else {
        		
        		if (!(sender instanceof ProxiedPlayer)) {
        			
        			sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Proxy support coming soon");
        			
        		} else {
        			
                    if (!messagers.containsKey(sender.getName())) {
                    	
                    	sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You have nobody to reply to, you must reieve a message first");
                    	return;
                    	
                    } else {
                    	
                    	ProxiedPlayer target = getProxy().getPlayer(messagers.get(sender.getName()));
                    	if (target == null) {
                    		
                    		sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You have nobody to reply to, you must reieve a message first");
                    		
                    	} else {
                    		
                            StringBuilder str = new StringBuilder();
                            for (int i = 0; i < args.length; i++) {
                                    str.append(args[i] + " ");
                            }
                            String message = str.toString();
                            
                            sender.sendMessage(ChatColor.LIGHT_PURPLE + "To " + target.getName() + ": " + ChatColor.RESET + message);
                    		target.sendMessage(ChatColor.LIGHT_PURPLE + "From " + sender.getName() + ": " + ChatColor.RESET + message);
                    		
                    	}
                    	
                    }
        			
        		}
        		
        	}
        }
      });    
  }
}